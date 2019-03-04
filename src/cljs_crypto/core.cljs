(ns cljs-crypto.core
  (:require
   [garden.core :refer [css]]
   [rum.core :refer [defc mount] :as rum]
   [cljs-crypto.input-label :as il]
   ))

(defn main-page [comp]
  (mount
   (comp)
   js/document.body))

;; (main-page hello-world-component)

;; fancy input box
;; (require '[cljs-crypto.input-label :as il])
(main-page il/fancy-input)

(comment

  ;; some rotating background image
  (require '[cljs-crypto.rotate :as rot])
  (main-page rot/happy-face))




