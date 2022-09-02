(ns tetriscljs.state
  (:require [reagent.core :as r]))

(def state
  (r/atom
    {:board (vec (for [r (range 18)]
              (vec (for [c (range 9)]
                     {:color "#000" :floating false}))))
     :score 0}))

(def board-cursor (r/cursor state [:board]))