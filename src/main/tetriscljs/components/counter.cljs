(ns tetriscljs.components.counter)

(defn Counter [{:keys [count inc-fn dec-fn]}]
  [:div.counter  ;; `.counter` is shorthand for `{:class "counter"}`
   [:div {:style {:display "flex" :justify-content "center"}}
    [:button.dec {:on-click dec-fn} "- 1"]
    [:span.val count]
    [:button.inc {:on-click inc-fn} "+ 1"]]])
