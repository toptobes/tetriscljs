(ns tetriscljs.app.views.background)

(declare left-gradient right-gradient top-gradient bottom-gradient)

(defn Background [& children]
  [:div.background
   [:div {:style left-gradient}]
   [:div {:style right-gradient}]
   [:div {:style top-gradient}]
   [:div {:style bottom-gradient}]
   children])

(defn gradient-str [rotation]
  (str "linear-gradient(" rotation ", #414141, transparent)"))

(def left-gradient
  {:position "absolute" :background-image (gradient-str "to right") :height "100%" :width "5vmax"})

(def right-gradient
  {:position "absolute" :background-image (gradient-str "to left") :height "100%" :width "5vmax" :right 0})

(def top-gradient
  {:position "absolute" :background-image (gradient-str "to bottom") :height "5vmax" :width "100%"})

(def bottom-gradient
  {:position "absolute" :background-image (gradient-str "to top") :height "5vmax" :width "100%" :bottom 0})