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

(defn main-page [comp]
  (mount
   (comp)
   js/document.body))

(main-page hello-world-component)

(comment

  ;; some rotating background image
  (require '[cljs-crypto.rotate :as rot])
  (main-page rot/happy-face)


  
  )




