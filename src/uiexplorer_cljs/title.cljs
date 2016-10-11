(ns uiexplorer-cljs.title
  (:require [uiexplorer-cljs.rn :refer [text view]]))

(def styles
  {:container {:border-radius 4
               :border-width 0.5
               :border-color "#d6d7da"
               :margin 10
               :margin-bottom 0
               :height 45
               :padding 10
               :background-color "white"}
   :text {:font-size 19
          :font-weight :500}})

(defn title [title]
  [view {:style (styles :container)}
    [text {:style (styles :text)} title]])
