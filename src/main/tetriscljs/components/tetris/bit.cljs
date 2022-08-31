(ns tetriscljs.components.tetris.bit)

(declare style)

(defn TetrisBit [{:keys [color x y]}]
  [:div
   {:style (assoc style :background-color "#FFF" )}])

(def style
  {:height       "calc(5%)"
   :aspect-ratio "1/1"})
