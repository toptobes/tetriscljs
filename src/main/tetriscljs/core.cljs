(ns tetriscljs.core
  (:require [reagent.core :as r]
            [reagent.dom :as rdom]
            [tetriscljs.components.tetris.tetris-background :refer [TetrisBackground]]
            [tetriscljs.components.tetris.bit :refer [TetrisBit]]
            [tetriscljs.components.background :refer [Background]]
            [tetriscljs.board-logic :refer [board-at board-add board-move-floating-down board-remove-floating]]
            [tetriscljs.pieces :as pieces]))

;; --- App State ---

;; Use `defonce` to preserve atom value across hot reloads
(def board
  (r/atom
    (into {} (for [x (range 9)
                   y (range 19)]
           [{:x x :y y} {:color "#000" :floating false}]))))

;; --- Utility Functions ---

;; --- App Component ---
(defn app []
  (prn @board)

  (reset! board (board-add @board (pieces/O-block) 2 2 "#FFF"))
  (reset! board (board-move-floating-down @board))
  (reset! board (board-move-floating-down @board))

  [Background
   [TetrisBackground
      (for [segment @board
            :let [coords (first segment)]
            :let [props (second segment)]]
        [TetrisBit {:color (:color props) :x (:x coords) :y (:y coords)}])]])

;; --- Render App ---

(defn render []
  (rdom/render [app] (.getElementById js/document "root")))

;; `^:export` metadata prevents function name from being munged during `:advanced` release compilation
(defn ^:export main []
  (println "Initial render")
  (render))

;; `^:dev/after-load` metadata hook tells Shadow-CLJS to run this function after each hot reload
(defn ^:dev/after-load reload! []
  (println "Reload!")
  (render))
