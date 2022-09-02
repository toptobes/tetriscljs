(ns tetriscljs.components.tetris.bit)

(declare style)

(defn TetrisBit [{:keys [color x y]}]
  [:div {:style (style color x y)}])

(defn style [color x y]
  {:height "calc(5%)"
   :aspect-ratio "1/1"
   :background-color color
   :position "absolute"
   :left (str "calc(10% * " x " + 5%)")
   :top (str "calc(5% * " y " + 2.5%)")})
