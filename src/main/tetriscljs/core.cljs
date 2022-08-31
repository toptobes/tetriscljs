(ns tetriscljs.core
  (:require [reagent.core :as r]
            [reagent.dom :as rdom]
            [tetriscljs.components.tetris.tetris-background :refer [TetrisBackground]]
            [tetriscljs.components.tetris.bit :refer [TetrisBit]]
            [tetriscljs.components.background :refer [Background]]))

;; --- App State ---

;; Use `defonce` to preserve atom value across hot reloads
(defonce count-tracker (r/atom 0))

;; --- Utility Functions ---

(defn increment! [r]
  (swap! r inc))

(defn decrement! [r]
  (swap! r dec))

;; --- App Component ---

(defn app []
  [Background
   [TetrisBackground
    [TetrisBit {:color "FFF"}]]])

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
