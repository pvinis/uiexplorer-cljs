(ns uiexplorer-cljs.page
  (:require [uiexplorer-cljs.rn    :refer [scroll-view text view]]
            [uiexplorer-cljs.title :refer [title]]))

(def styles
  {:container {:background-color "#e9eaed"
               :flex 1}
   :spacer {:height 270}
   :wrapper {:flex 1
             :paddingTop 10}})

(defn page [{ptitle     :title
             no-spacer :no-spacer
             no-scroll :no-scroll} & children]
  (let [title (if (some? ptitle) [title ptitle] nil)
        content-wrapper (if (some? no-scroll) view scroll-view)
        spacer (if (some? no-spacer) nil [view {:style (styles :spacer)}])]
    (fn []
      [view {:style (styles :container)}
        title
        [content-wrapper {:style (styles :wrapper)}
          children
          spacer]])))
