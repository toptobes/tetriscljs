(ns tetriscljs.pieces)

(declare I-block J-block L-block O-block S-block T-block Z-block)

(defn I-block []
  [{:x 0 :y -2}
   {:x 0 :y -1}
   {:x 0 :y 0}
   {:x 0 :y 1}])

(defn J-block []
  [{:x 0 :y -2}
   {:x 0 :y -1}
   {:x 0 :y 0}
   {:x -1 :y 0}])

(defn L-block []
  [{:x 0 :y -2}
   {:x 0 :y -1}
   {:x 0 :y 0}
   {:x 1 :y 0}])

(defn O-block []
  [{:x -1 :y -1}
   {:x 0 :y -1}
   {:x 0 :y 0}
   {:x -1 :y 0}])

(defn S-block []
  [{:x 1 :y 0}
   {:x 0 :y 0}
   {:x 0 :y -1}
   {:x -1 :y -1}])

(defn T-block []
  [{:x -1 :y 0}
   {:x 1 :y 0}
   {:x 0 :y 0}
   {:x 0 :y -1}])

(defn Z-block []
  [{:x -1 :y 0}
   {:x 0 :y 0}
   {:x 0 :y -1}
   {:x 1 :y -1}])