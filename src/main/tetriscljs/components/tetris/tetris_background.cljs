(ns tetriscljs.components.tetris.tetris-background)

(declare background)

(defn TetrisBackground [& children]
  [:div {:style background}
   children])

(def background
  {:background-color "#343434"
   :filter "drop-shadow(5px 5px 10px #0003)"
   :height "95%"
   :aspect-ratio "1/2"
   :border-radius "20px"
   :padding "10px"
   :position "absolute"
   :top "50%"
   :left "50%"
   :transform "translate(-50%, -50%)"})
