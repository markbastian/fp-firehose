(ns conway.timing
  (:require [conway.rules :as c]))

;Takes abou 0.1 seconds
(let [t (System/nanoTime)
      g (first (take 10 (iterate c/step (c/seed-grid 1000 1000))))
      dt (- (System/nanoTime)t )]
  (prn (str (get-in g [50 50]) ": " (* dt 1.0E-9))))

(let [t (System/nanoTime)
      g (first (take 10 (iterate c/step (c/seed-grid 100 100))))
      dt (- (System/nanoTime)t )]
  (prn (str (get-in g [50 50]) ": " (* dt 1.0E-9))))
