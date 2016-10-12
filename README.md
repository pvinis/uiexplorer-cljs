# uiexplorer-cljs



misha [10:22 PM]  
@pvinis the way you wrote it should work. except maybe not ~console~, but js/console.
here's what I have (for rum though):
```(defn alert
  ([title]
   (.alert (.-Alert ReactNative) title))
  ([title msg]
   (.alert (.-Alert ReactNative) title msg))
  ([title msg buttons]
   (.alert (.-Alert ReactNative) title msg (clj->js buttons))))

(defn alert-button
  ([txt]
   #js {:text txt})
  ([txt on-click]
   #js {:text txt :onPress on-click}))
```

[10:25]  
actually, try replacing `(clj->js [{...}])` with `[#js {..}]`, because:
```cljs.user=> (clj->js [{:text "OKd" :onPress (fn [] 3)}])
#js [#js {:text "OKd", :onPress #object[Function "function (){return (3);}"]}]

cljs.user=> [#js {:text "OKd" :onPress (fn [] 3)}]
    [#js {:text "OKd", :onPress #object[onPress "function (){return (3);}"]}]





vikeri [9:22 AM]  
@pvinis: I have this:
(`camelify-map-keys` is from `reagent.impl.component`)
```(def alert (fn [{:keys [title message buttons]}]
             (.alert (.-Alert react-native)
                     (str title)
                     message (clj->js (mapv camelify-map-keys buttons)))))
```
The input then looks like this:
```{:text    "Text"
 :message "Message"
 :buttons [{:text  "Cancel"
            :style "cancel"}
           {:text "OK"
            :fn/on-press
                  #(dispatch [:alert/ok])}]}


A Clojure library designed to ... well, that part is up to you.


react-native commit
770091f3c13f7c1bd77c50f979d89a774001fbf0



To get started with your new app, first cd into its directory:
cd uiexplorer-cljs

Run iOS app:
react-native run-ios > /dev/null

To use figwheel type:
re-natal use-figwheel
lein figwheel ios

Reload the app in simulator (⌘ + R)

At the REPL prompt type this:
(in-ns 'uiexplorer-cljs.ios.core)

Changes you make via the REPL or by changing your .cljs files should appear live.

Try this command as an example:
(dispatch [:set-greeting "Hello Native World!"])

✔ Done

purple:Source pvinis$ pwd
/Users/pvinis/Source
purple:Source pvinis$ cd
.DS_Store        pvinis/          uiexplorer-cljs/
purple:Source pvinis$ cd uiexplorer-cljs/
purple:uiexplorer-cljs pvinis$ cd
purple:~ pvinis$ cd Source/pvinis/uiexplorer-cljs/
purple:uiexplorer-cljs pvinis$
## Usage

FIXME

## License

Copyright © 2016 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
