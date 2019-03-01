(ns cljs-crypto.core
  (:require
   [rum.core :refer [defc mount] :as rum]))

(defc hello-world-component
  []
  [:h1 "Hello my friendly, lovely world!"])

(defn main-page []
  (mount
   (hello-world-component)
   js/document.body))

(main-page)
