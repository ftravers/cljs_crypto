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

(defc fancy-input []
  [:div
   ;; [:style (get-style)]
   [:style (css my-style)]
   [:span {:class :input-field}
    [:input {:type :text
             :required true
             :id :name}]
    [:label {:for :name} "Your Name:"]]
   [:span {:class :input-field}
    [:input {:type :text
             :required true
             :id :phone}]
    [:label {:for :phone} "Phone Number:"]]])

