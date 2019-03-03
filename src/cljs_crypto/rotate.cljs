(ns cljs-crypto.rotate
  (:require [rum.core :refer [defc]])
  )

(defc happy-face
  []
  [:img {:id :happy-face
         :src "happy-face.jpg"}])

(defn rotate-happy-face [deg]
  (let [img (.getElementById js/document "happy-face")]
    (set! (-> img .-style .-transform) (str "rotate(" deg "deg)"))))

(.addEventListener
 js/window "scroll"
 #(let [pxs (.-scrollY js/window)]
    (rotate-happy-face pxs)))
