(ns uiexplorer-cljs.layout-example
  (:require [uiexplorer-cljs.rn    :refer [text view]]
            [uiexplorer-cljs.block :refer [block]]
            [uiexplorer-cljs.page  :refer [page]]))

(def styles
  {:overlay {:background-color "#aaccff"
             :border-radius 10
             :border-width 0.5
             :opacity 0.5
             :padding 5}})

(defn circle [{psize    :size
               bg-color :bg-color}]
  (let [size             (or psize 20)
        background-color (or bg-color "#527fe4")]
    (fn []
      [view {:style {:border-radius (/ size 2)
                     :background-color background-color
                     :width  size
                     :height size
                     :margin 1}}])))

(defn circle-block [{style :style} & children]
  (let [circle-style {:flex-direction :row
                      :background-color "#f6f7f8"
                      :border-width 0.5
                      :border-color "#d6d7da"
                      :margin-bottom 2}]
   (fn []
     [view {:style (merge circle-style style)}
       [text "a"]
       children
       [text "a"]])))

(defn layout-example [{navigator :navigator}]
  (let [circle-1 [circle {:bg-color "#527fe4" :key "blue"}] ;;;;; better way to write this..
        circle-2 [circle {:bg-color "#D443E3" :key "violet"}]
        circle-3 [circle {:bg-color "#FF9049" :key "orange"}]
        circle-4 [circle {:bg-color "#FFE649" :key "yellow"}]
        circle-5 [circle {:bg-color "#7FE040" :key "green"}]]
    (fn []
      [page {:title (if (some? navigator) nil "Layout")}
        [block {:title "Flex Direction"}
          [text "row"]
          [circle-block {:style {:flex-direction :row}}
            circle-1
            circle-2
            circle-3
            circle-4
            circle-5]
          [text "row-reverse"]
          [circle-block {:style {:flex-direction :row-reverse}}
            circle-1
            circle-2
            circle-3
            circle-4
            circle-5]
          [text "column"]
          [circle-block {:style {:flex-direction :column}}
            circle-1
            circle-2
            circle-3
            circle-4
            circle-5]
          [text "column-reverse"]
          [circle-block {:style {:flex-direction :column-reverse}}
            circle-1
            circle-2
            circle-3
            circle-4
            circle-5]
          [view {:style (merge (styles :overlay) {:position :absolute :top 15 :left 160})}
            [text "{:top 15 :left 160}"]]]

        [block {:title "Justify Content - Main Direction"}
          [text "flex-start"]
          [circle-block {:style {:justify-content :flex-start}}
            circle-1
            circle-2
            circle-3
            circle-4
            circle-5]
          [text "center"]
          [circle-block {:style {:justify-content :center}}
            circle-1
            circle-2
            circle-3
            circle-4
            circle-5]
          [text "flex-end"]
          [circle-block {:style {:justify-content :flex-end}}
            circle-1
            circle-2
            circle-3
            circle-4
            circle-5]
          [text "space-between"]
          [circle-block {:style {:justify-content :space-between}}
            circle-1
            circle-2
            circle-3
            circle-4
            circle-5]
          [text "space-around"]
          [circle-block {:style {:justify-content :space-around}}
            circle-1
            circle-2
            circle-3
            circle-4
            circle-5]]

        [block {:title "Align Items - Other Direction"}
          [text "flex-start"]
          [circle-block {:style {:justify-content :flex-start :height 30}}
            circle-1
            circle-2
            circle-3
            circle-4
            circle-5]
          [text "center"]
          [circle-block {:style {:justify-content :center :height 30}}
            circle-1
            circle-2
            circle-3
            circle-4
            circle-5]
          [text "flex-end"]
          [circle-block {:style {:justify-content :flex-end :height 30}}
            circle-1
            circle-2
            circle-3
            circle-4
            circle-5]]

        [block {:title "Flex Wrap"}
          [circle-block {:style {:flex-wrap :wrap}}]]])))
