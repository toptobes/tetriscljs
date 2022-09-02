(ns tetriscljs.board-logic)

(declare set-piece-coords board-add board-at board-remove-floating)

(defn board-at [board x y]
  (nth (nth board x) y))

(defn board-add [board piece x y color]
  (let [piece (map (set-piece-coords x y) piece)
        add-bit-to-board #(assoc %1 %2 {:floating true :color color})
        new-board (reduce add-bit-to-board board piece)]
    new-board))

(defn board-move-floating-down [board]
  (let [are-floating (fn [[_ props]] (:floating props))
        move-down (fn [[coords _]] (assoc coords :y (dec (:y coords))))
        old-floating (filter are-floating board)
        new-floating (map move-down old-floating)
        new-pieces (merge old-floating new-floating)
        add-bit-to-board #(assoc %1 (key %2) (val %2))]))

(defn board-remove-floating [board]
  (let [remove-if-floating #(if (:floating %1) {:floating false :color "#000"} %1)]
    (map remove-if-floating board)))

(defn- set-piece-coords [origin-x origin-y]
  (fn [{x :x y :y}]
    {:x (+ origin-x x) :y (+ origin-y y)}))
