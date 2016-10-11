(ns uiexplorer-cljs.rn
  (:require [reagent.core :as r]))

(def ReactNative (js/require "react-native"))

(def app-registry (.-AppRegistry ReactNative))

(defn alert [title & rest]
  (.apply (.. ReactNative -Alert -alert) nil (clj->js (cons title rest))))

(def image               (r/adapt-react-class (.-Image              ReactNative)))
(def platform            (r/adapt-react-class (.-Platform           ReactNative)))
(def scroll-view         (r/adapt-react-class (.-ScrollView         ReactNative)))
(def text                (r/adapt-react-class (.-Text               ReactNative)))
(def touchable-highlight (r/adapt-react-class (.-TouchableHighlight ReactNative)))
(def view                (r/adapt-react-class (.-View               ReactNative)))
