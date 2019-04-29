(ns cljs-crypto.input-label
  (:require [rum.core :refer [defc]]
            [garden.core :refer [css]]))

(def my-style
  [[:.input-field
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
            :color "#111"}]
   [:input:invalid {:outline 1}]
   [:input:focus :input:valid {:border-color "#00dd22"}]
   ["input:focus~label,input:valid~label"
    {:font-size "14px"
     :top "-24px"
     :color "#dddd22"}]])

(defn fancy-input-2 [label id additional-attrs]
  [:span {:class :input-field}
   [:input
    (merge {:type :text
            :required true
            :id id}
           additional-attrs)]
   [:label {:for id} label]])

(def form-style
  [[:.fancy-form
    {:display :grid
     :grid-gap "20px"
     :grid-auto-rows "minmax(min-content, max-content)"
     :grid-auto-columns "minmax(min-content, 200px)"
     }]])

(defc fancy-input []
  [:div {:class :fancy-form}
   [:style (css (concat form-style my-style))]
   (fancy-input-2 "Your Name:" :name {:required true})
   (fancy-input-2  "Phone Number:" :phone {:required true})])

