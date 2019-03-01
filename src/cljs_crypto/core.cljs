(ns cljs-crypto.core
  (:require
   [garden.core :refer [css]]
   [rum.core :refer [defc mount] :as rum]))

(def my-style
  [[:.my-1st-class
    {:font-size "2em"}]])

(defc hello-world-component
  []
  [:div
   [:style (css my-style)]
   [:p {:class :my-1st-class}
    "Hello lovely world!"]])

(defn main-page []
  (mount
   (hello-world-component)
   js/document.body))

(main-page)
