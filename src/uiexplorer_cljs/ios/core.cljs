(ns uiexplorer-cljs.ios.core
  (:require [reagent.core :as r :refer [atom]]
            [re-frame.core :refer [subscribe dispatch dispatch-sync]]
            [uiexplorer-cljs.title :refer [title]]
            [uiexplorer-cljs.example-container :refer [example-container]]
            [uiexplorer-cljs.block :refer [block]]
            [uiexplorer-cljs.alert-example :refer [simple-alert-example-block]]
            [uiexplorer-cljs.layout-example :refer [circle circle-block layout-example]]
            [uiexplorer-cljs.events]
            [uiexplorer-cljs.subs]))

(def ReactNative (js/require "react-native"))

(def app-registry (.-AppRegistry ReactNative))
(def text (r/adapt-react-class (.-Text ReactNative)))
(def view (r/adapt-react-class (.-View ReactNative)))
(def image (r/adapt-react-class (.-Image ReactNative)))
(def touchable-highlight (r/adapt-react-class (.-TouchableHighlight ReactNative)))

(def logo-img (js/require "./images/cljs.png"))

(defn alert [title]
      (.alert (.-Alert ReactNative) title))

(defn app-root []
  (let [greeting (subscribe [:get-greeting])]
    (fn []
      [view {:style {:flex-direction "column" :margin 40 :align-items "center"}}
       [title "yo"]
      ;  [example-container {:module "asd"}]
       [simple-alert-example-block]
      ;  [circle]
      ;  [circle-block]
      ;  [layout-example]
      ;  [circle]
       [block {:title "titl"
              ;  :description "desc"
               :children [text "a"]}]
       [image {:source logo-img
               :style  {:width 80 :height 80 :margin-bottom 30}}]
       [touchable-highlight {:style {:background-color "#999" :padding 10 :border-radius 5}
                             :on-press #(alert "HELLO!")}
        [text {:style {:color "white" :text-align "center" :font-weight "bold"}} "ss me"]]])))

(defn init []
      (dispatch-sync [:initialize-db])
      (.registerComponent app-registry "UIExplorerCLJS" #(r/reactify-component app-root)))
