(ns tetriscljs.components.background)

(declare background background-gradient left-gradient right-gradient top-gradient bottom-gradient)

(defn Background [& children]
  [:div {:style background}
   [:div {:style left-gradient}]
   [:div {:style right-gradient}]
   [:div {:style top-gradient}]
   [:div {:style bottom-gradient}]
   [:div {:style background-gradient}]
   children])

(def background
  {:height "100vh" :width "100vw"
   :color "aliveclue" :background-color "#414141"
   :background-size "40px 40px"
   :background-image "linear-gradient(to right, rgba(128, 128, 128, .15) 1px, transparent 1px),
                      linear-gradient(to bottom, rgba(128, 128, 128, .18) 1px, transparent 1px)"})

(def background-gradient
  {:height "100vh" :width "100vw"
   :position "absolute"
   :background-image "linear-gradient(to top, rgba(0, 0, 0, .35), transparent)"})

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