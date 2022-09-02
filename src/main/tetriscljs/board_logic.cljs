(ns tetriscljs.board-logic)

(declare set-piece-coords board-add board-at)

(defn- set-piece-coords [origin-x origin-y]
  (fn [{x :x y :y}]
    {:x (+ origin-x x) :y (+ origin-y y)}))

(defn board-add [board piece x y color]
  (let [piece (map (set-piece-coords x y) piece)
        add-bit-to-board #(assoc-in %1 [(:x %2) (:y %2)] {:floating true :color color})
        new-board (reduce add-bit-to-board board piece)]
    new-board))

(defn board-remove-floating [board]
  (let [remove-if-floating #(if (:floating %1) {:floating false :color "#000"} %1)]
    (map remove-if-floating board)))

(defn board-at [board x y]
  (nth (nth board x) y))

;(defn board-add [board piece x y]
;  (let [piece (map (set-piece-coords x y) piece)
;        new-board (loop [bits piece board board]
;                    (let [x (:x (last bits))
;                          y (:y (last bits))
;                          new-board (assoc-in board [x y] 1)]
;                      (if (> (count bits) 1)
;                        (recur (drop-last bits) new-board)
;                        new-board)))]
;    new-board))

;(defn board-add [board piece x y]
;  (let [piece (map (set-piece-coords x y) piece)
;        add-bit-to-board #(assoc-in %1 [(:x %2) (:y %2)] 1)
;        new-board (reduce add-bit-to-board board piece)]
;    new-board))







