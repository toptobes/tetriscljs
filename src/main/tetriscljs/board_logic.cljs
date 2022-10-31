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
        move-down (fn [[coords props]] [(assoc coords :y (inc (:y coords))) props])
        old-floating (filter are-floating board)
        new-floating (into {} (map move-down old-floating))
        board-wo-floating (board-remove-floating board)
        new-board (merge board-wo-floating new-floating)]
    new-board))

(defn board-remove-floating [board]
  (let [remove-if-floating #(if
                              (:floating (second %1))
                                [(first %1) {:floating false :color "#000"}]
                                %1)]
    (into {} (map remove-if-floating board))))

(defn- set-piece-coords [origin-x origin-y]
  (fn [{x :x y :y}]
    {:x (+ origin-x x) :y (+ origin-y y)}))
