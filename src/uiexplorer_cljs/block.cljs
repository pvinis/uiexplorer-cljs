(ns uiexplorer-cljs.block
  (:require [uiexplorer-cljs.rn :refer [text view]]))

(def styles
  {:container {:border-radius 3
               :border-width 0.5
               :border-color "#d6d7da"
               :background-color "#ffffff"
               :margin 10
               :margin-vertical 5
               :overflow :hidden}
   :title-container {:border-bottom-width 0.5
                     :border-top-left-radius 3
                     :border-top-right-radius 2.5
                     :border-bottom-color "#d6d7da"
                     :background-color "#f6f7f8"
                     :padding-horizontal 10
                     :padding-vertical 5}
   :title-text {:font-size 14
                :font-weight :500}
   :description-text {:font-size 14}
   :disclosure {:position :absolute
                :top 0
                :right 0
                :padding 10}
   :disclosure-icon {:width 12
                     :height 8}
   :children {:margin 10}})

(defn block [{title       :title
              description :description} & children]
  (let [description-view (if (some? description)
                             [text {:style (styles :description-text)} description])]
    (.log js/console description-view)
    (fn []
      [view {:style (styles :container)}
        [view {:style (styles :title-container)}
          [text {:style (styles :title-text)} title]
          description-view]
        [view {:style (styles :children)}
          children]])))
