(ns uiexplorer-cljs.alert-example
  (:require [uiexplorer-cljs.rn    :refer [alert text touchable-highlight view ReactNative]]
            [uiexplorer-cljs.block :refer [block]]))

(def styles
  {:wrapper {:border-radius  5
             :margin-bottom  5}
   :button {:background-color "#eeeeee"
            :padding 10}})

(def alert-message
  (str "Credibly reintermediate next-generation potentialities after goal-oriented "
       "catalysts for change. Dynamically revolutionize."))

(defn alertt [title]
  (.alert (.-Alert ReactNative) title "asd"))

(defn simple-alert-example-block []
  [view
    [touchable-highlight {:style (styles :wrapper)
                          :on-press (fn [] (alert "Alert Title" alert-message))}
      [view {:style (styles :button)}
        [text "Alert with message and default button"]]]
    [touchable-highlight {:style (styles :wrapper)
                          :on-press (fn [] (alert "Alert Title" alert-message
                                                  (clj->js [{:text "OK"
                                                             :onPress (fn [] (.log js/console "OK Pressed!"))}])))};;;;;;;;;make it on-press and clj->js should convert it
      [view {:style (styles :button)}
        [text "Alert with one button"]]]
    [touchable-highlight {:style (styles :wrapper)
                          :on-press (fn [] (alert "Alert Title" alert-message
                                                  (clj->js [{:text "Cancel"
                                                             :onPress (fn [] (.log js/console "Cancel Pressed!"))}
                                                            {:text "OK"
                                                             :onPress (fn [] (.log js/console "OK Pressed!"))}])))}
      [view {:style (styles :button)}
        [text "Alert with two buttons"]]]
    [touchable-highlight {:style (styles :wrapper)
                          :on-press (fn [] (alert "Alert Title" nil
                                                  (clj->js [{:text "Foo";;;;;;; clj->js is compile time. replace with #js?
                                                             :onPress (fn [] (.log js/console "Foo Pressed!"))}
                                                            {:text "Bar"
                                                             :onPress (fn [] (.log js/console "Bar Pressed!"))}
                                                            {:text "Baz"
                                                             :onPress (fn [] (.log js/console "Baz Pressed!"))}])))}
      [view {:style (styles :button)}
        [text "Alert with three buttons"]]]
    [touchable-highlight {:style (styles :wrapper)
                          :on-press (fn [] (alert "Alert Title" alert-message))}
                                                  ;;;;;;;;;;;
      [view {:style (styles :button)}
        [text "Alert with too many buttons"]]]
    [touchable-highlight {:style (styles :wrapper)
                          :on-press (fn [] (alert "Alert Title" nil
                                                  (clj->js [{:text "OK"
                                                             :onPress (fn [] (.log js/console "OK Pressed!"))}])
                                                  (clj->js {:cancelable false})))}
      [view {:style (styles :button)}
        [text "Alert that cannot be dismissed"]]]])

(defn alert-example []
  (let [title "Alert"
        description (str "Alerts display a concise and informative message "
                         "and prompt the user to make a decision.")]
    (fn []
      [block {:title "Alert"}
        [simple-alert-example-block]])))
