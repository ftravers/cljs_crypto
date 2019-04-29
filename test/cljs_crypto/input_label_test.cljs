(ns cljs-crypto.input-label-test
  (:require [cljs-crypto.input-label :as il]
            [cljs.test
             :refer-macros [are deftest is testing run-tests]
             :as t :include-macros true]))

(deftest set-styles-test
  (testing "override styles"
    (is (= nil
           (il/set-styles
            il/fancy-style
            {:label {:color "#0000aa"}})))

    ;; (are [result existing-styles set-styles]
    ;;     (= result (il/set-styles existing-styles set-styles))

    ;;     [["input:focus~label,input:valid~label"
    ;;       {:font-size "14px"
    ;;        :top "-24px"
    ;;        :color "#dddd22"}]
    ;;      [:input:invalid {:outline 1
    ;;                       :color :green}]]
    ;;     [["input:focus~label,input:valid~label"
    ;;       {:font-size "14px"
    ;;        :top "-24px"
    ;;        :color "#dddd22"}]
    ;;      [:input:invalid {:outline 1}]]
    ;;     {:input:invalid {:color :green}})
    ))

(run-tests)
