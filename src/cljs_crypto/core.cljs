(ns cljs-crypto.core
  (:require
   [garden.core :refer [css]]
   [rum.core :refer [defc mount] :as rum]
   [cljs-crypto.input-label :as il]))

(defn main-page [comp]
  (mount
   (comp)
   (js/document.getElementById "app")))

;; (defc fancy-input []
;;   [:div {:class :fancy-form}
;;    "hello"
;;    [:style (css (il/set-styles
;;                  il/fancy-style
;;                  [[:label {:color "#0000aa"}]
;;                   [:input {:color "#0000aa"}]
;;                   ["input:focus~label,input:valid~label"
;;                    {:color "#0000aa"}]
;;                   [:input:focus :input:valid
;;                    {:border-color "#0000aa"}]]))]
;;    (il/fancy-input {:label "Your Name:"
;;                     :id :name
;;                     :required true})

;;    (il/fancy-input {:label "Phone Number:"
;;                     :id :phone
;;                     :required true})])


;; (defc fancy-input []
;;   [:div
;;    (il/fancy-input {:label "Your Name:"
;;                     :id ::name
;;                     :required true})

;;    [:style (css il/fancy-style)]])

(defc fancy-input []
  [:div
   [:style (css (il/set-styles
                 [[:label {:color "#0000aa"}]
                  [:input {:color "#0000aa"}]
                  [:input:focus :input:valid {:border-color "#0000aa"}]]))]
   (il/fancy-input {:label "Your Name:"
                    :id :name
                    :required true})])
(main-page fancy-input)






