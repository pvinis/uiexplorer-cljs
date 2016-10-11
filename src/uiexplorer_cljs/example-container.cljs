(ns uiexplorer-cljs.example-container
  (:require [uiexplorer-cljs.rn   :refer [platform text view]]
            [uiexplorer-cljs.page :refer [page]]))

(defn example-container [{module :module}]
  [page {:title "ok"}])
