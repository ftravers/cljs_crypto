(ns cljs-crypto.input-label
  (:require [rum.core :refer [defc]]
            [clojure.string :as c-s]
            [clojure.test :as tst :refer [is are]]
            [garden.core :refer [css]]))

(def fancy-style
  [[:.fancy-form
    {:display :grid
     :grid-gap "20px"
     :grid-auto-rows "minmax(min-content, max-content)"
     :grid-auto-columns "minmax(min-content, 200px)"}]
   [:.input-field
    {:position "relative"
     :line-height "44px"}]
   [:label {:position "absolute"
            :top 0
            :left 0
            :color "#d3d3d3"
            :transition "0.2s all"}]
   [:input {:border 0
            :outline 0
            :padding "0.5rem 0"
            :border-bottom "2px solid #d3d3d3"
            :box-shadow "none"
            :color "#090"}]
   [:input:invalid {:outline 1}]
   [:input:focus :input:valid {:border-color "#00dd22"}]
   ["input:focus~label,input:valid~label"
    {:font-size "14px"
     :top "-24px"
     :color "#dddd22"}]])

(defn fancy-input
  [{:keys [label id]
    :as additional-attrs}]
  [:span {:class :input-field}
   [:input
    (merge {:type :text :id id}
           additional-attrs)]
   [:label {:for id} label]])

(defn to-key-lst
  {:test (fn [] (is (= [:a :b] (to-key-lst ":a :b"))))}
  [k]
  (mapv
   #(->> %
         (drop 1)
         (apply str)
         keyword)
   (c-s/split k #" ")))

(defn make-vector
  {:test
   (fn []
     (are [expected input]
         (= expected (make-vector input))
         [[:a :b {:c 1}] [":c:d" {:d 2}]]
         {":a :b" ^{:key-type :keyword} {:c 1}
          ":c:d" ^{:key-type :string} {:d 2}}))}
  [input-m]
  (into
   []
   (for [[k v] input-m]
     (let [kee (case (:key-type (meta v))
                 :keyword (to-key-lst k)
                 :string [k])]
       (conj kee v)))))

(defn make-map
  "input 'keys' can be either a list of keywords or a string, save that info into resulting map value"
  {:test
   (fn []
     (is (= {":a :b" {:color :blue}
             ":d" {:color :green}
             ":c" {:color :red}}
            (make-map [[:a :b {:color :blue}]
                       [":d" {:color :green}]
                       [:c {:color :red}]])))
     (are [expected input get-key]
         (= expected
            (-> (make-map input) (get get-key) meta :key-type))

         :keyword
         [[:a :b {:color :blue}]]
         ":a :b"

         :string
         [[":a:b" {:color :blue}]]
         ":a:b"))}
  [styles-v]
  (reduce 
   (fn [accumulator curr-item]
     (let [selector-type (first curr-item)
           key-type
           (cond
             (keyword? selector-type) :keyword
             (string? selector-type) :string)
           new-key (c-s/join " " (butlast curr-item))
           style-map (last curr-item)
           valu (vary-meta style-map merge {:key-type key-type})]
       (println "style: " style-map valu (meta valu))
       
       (assoc accumulator new-key valu)))
   {}
   styles-v))

(defn merge-maps
  "for any key that exists in both maps, merged the values.
  otherwise simply merge the two maps."
  {:test
   (fn []
     (is
      (=
       {:a {:z 3 :y 2}
        :b {:x 5}
        :c {:u 1}
        :d {:v 7}}
       (merge-maps {:a {:z 1 :y 2}
                    :b {:x 4}
                    :d {:v 7}}
                   {:a {:z 3}
                    :b {:x 5}
                    :c {:u 1}}))))}
  [old-m new-m]
  (let [merged-new-m
        (reduce
         (fn [acc [k v]]
           (assoc acc k
                  (merge (get old-m k) v)))
         {}
         new-m)
        old-keys-removed (dissoc old-m (keys new-m))]
    (merge old-keys-removed merged-new-m)))

(defn set-styles
  {:test
   (fn []
     (is (=
          [[:a :b {:color :red}]
           [:c {:color :green}]]
          (set-styles [[:a :b {:color :blue}]
                       [:c {:color :green}]]
                      [[:a :b {:color :red}]]))))}
  ([overrides]
   (set-styles fancy-style overrides))
  ([existing overrides]
   "update *existing* styles as specified by *override*"
   (let [existing-m (make-map existing)
         overrides-m (make-map overrides)]
     (-> (merge-maps existing-m overrides-m)
         make-vector))))
