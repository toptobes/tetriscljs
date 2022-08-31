(ns tetriscljs.app.views.header)

(def cljs-icon "/img/cljs.svg")

(defn Header []
  [:div {:style {:display "flex", :align-items "center"}}
   [:img {:src cljs-icon :width 120}]
   [:h1 {:style {:padding "1rem", :font-weight "bold"}}
    "Create Reagent App"]])
