(ns tetriscljs.app.core
  (:require [reagent.core :as r]
            [reagent.dom :as rdom]
            [tetriscljs.app.views.aside :refer [Aside]]
            [tetriscljs.app.views.counter :refer [Counter]]
            [tetriscljs.app.views.description :refer [Description]]
            [tetriscljs.app.views.header :refer [Header]]
            [tetriscljs.app.views.background :refer [Background]]))

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
   [:div.wrapper
    [Header]
    [Description]
    [Aside]
    [Counter {:count  (str @count-tracker)
              :inc-fn #(increment! count-tracker)
              :dec-fn #(decrement! count-tracker)}]]])

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
