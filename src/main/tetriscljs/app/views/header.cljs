(ns tetriscljs.app.views.header)

(def cljs-icon "/img/cljs.svg")

(declare wrapper header strike-through)

(defn Header []
  [:div {:style wrapper}
   [:img {:src cljs-icon :width 120 :style {:filter "contrast(130%)"}}]
   [:h1 {:style header}
    (strike-through "Create Reagent App") "Tetris soon"]])

(def wrapper
  {:display "flex", :align-items "center"})

(def header
  {:padding "1rem", :font-weight "bold"})

(defn strike-through [str]
  [:span {:style {:text-decoration "line-through"}}
   str])
