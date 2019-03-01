(ns cljs-crypto.core
  (:require
   [garden.core :refer [css]]
   [rum.core :refer [defc mount] :as rum]))

(def my-style
  [[:.my-1st-class
    {:font-size "3em"}]
   [:.my-2nd-class
    {:color "red"}]])

(defc hello-world-component
  []
  [:div
   [:style (css my-style)]
   [:p {:class :my-1st-class}
    "Hello lovely world!"]
   [:p {:class :my-2nd-class}
    "Nice to meet you."]])

(defn main-page []
  (mount
   (hello-world-component)
   js/document.body))

(main-page)
