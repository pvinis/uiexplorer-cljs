(ns uiexplorer-cljs.rn
  (:require [reagent.core :as r]))

(def ReactNative (js/require "react-native"))

(def app-registry (.-AppRegistry ReactNative))

(def image               (r/adapt-react-class (.-Image              ReactNative)))
(def scroll-view         (r/adapt-react-class (.-ScrollView         ReactNative)))
(def text                (r/adapt-react-class (.-Text               ReactNative)))
(def touchable-highlight (r/adapt-react-class (.-TouchableHighlight ReactNative)))
(def view                (r/adapt-react-class (.-View               ReactNative)))
