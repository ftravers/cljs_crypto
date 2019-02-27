(ns cljs-crypto.core
  (:require
   [rum.core :refer [defc mount] :as rum]))

(defc hello-world-component
  []
  [:h1 "Browser Crypto"])

#?(:cljs (defn main-page []
           (mount
            (hello-world-component)
            js/document.body)))

#?(:cljs (main-page))
