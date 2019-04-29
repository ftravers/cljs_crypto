(ns cljs-crypto.input-label-test
  (:require
   [cljs-crypto.input-label :as il]
   [clojure.test :as tst :refer [deftest testing is are]]))

(deftest set-styles-2-test

      (= expected (il/set-styles) )))
  (are []
(deftest set-styles-2-test

    (are [result existing-styles set-styles]
  (testing "override styles"
           (il/set-styles
        (= result
            set-styles))
            existing-styles
            override-styles))
      
        [[:input {:color :green}]
         [:label {:color :blue}]]
        [[:input {:color "#aa00bb"}]
         [:label {:color "#00aabb"}]]
        {:input {:color :green}
         :label {:color :blue}}

        [["input:focus~label,input:valid~label"
          {:font-size "14px"
           :top "-24px"
           :color "#dddd22"}]
         [:input:invalid {:outline 1
                          :color :green}]]
        [["input:focus~label,input:valid~label"
          {:font-size "14px"
           :top "-24px"
           :color "#dddd22"}]
         [:input:invalid {:outline 1}]]
(deftest set-styles-2-test
    (are [result existing-styles set-styles]
  (testing "override styles"
           (il/set-styles
        (= result
            set-styles))
            existing-styles
            override-styles))

        [[:input:focus :input:valid {:border-color "#00dd22" :color "#0000aa"}]]
        [[:input:focus :input:valid {:border-color "#00dd22"}]]
        [[:input:focus :input:valid  {:color "#0000aa"}]]
        
        [[:input:focus :input:valid {:border-color :blue}]]
        [[:input:focus :input:valid {:border-color :green}]]
        [[:input:focus :input:valid {:border-color :blue}]]
        
        [[:input {:color :green}]
         [:label {:color :blue}]]
        [[:input {:color "#aa00bb"}]
         [:label {:color "#00aabb"}]]
        [[:input {:color :green}]
         [:label {:color :blue}]]

        [["input:focus~label,input:valid~label"
          {:font-size "14px"
           :top "-24px"
           :color "#dddd22"}]
         [:input:invalid {:outline 1
                          :color :green}]]
        [["input:focus~label,input:valid~label"
          {:font-size "14px"
           :top "-24px"
           :color "#dddd22"}]
         [:input:invalid {:outline 1}]]
        {:input:invalid {:color :green}})))

