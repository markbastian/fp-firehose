(ns conway.core
  (:gen-class)
  (:require [conway.rules])
  (:import (javax.swing JFrame JPanel JButton JCheckBox Box BoxLayout)
           (java.awt BorderLayout Graphics2D Color ImageCapabilities)
           (java.awt.geom Rectangle2D$Double)
           (java.awt.event ActionListener)
           (java.awt.image VolatileImage)))

(defn panel [grid-ref]
  (let [pnl (proxy [JPanel] []
    (paint [g]
      (let [w (.getWidth this) 
            h (.getHeight this)
            bg (Rectangle2D$Double. 0 0 w (.getHeight this))
            vimg (.createVolatileImage this w h (ImageCapabilities. true))
            g2d (.createGraphics vimg)]
        (doto g2d
          (.setPaint Color/BLACK)
          (.fill bg))
        (doseq [i (range (count @grid-ref))]
          (doseq [j (range (count (get @grid-ref i)))]
            (let [c (if (= :alive (get-in @grid-ref [i j])) Color/GREEN Color/RED)
                  sq (Rectangle2D$Double. (* i (/ w (count @grid-ref)))
                                          (* j (/ h (count (get @grid-ref i))))
                                          (/ w (count @grid-ref))
                                          (/ h (count (get @grid-ref i))))]
              (do
                (.setPaint g2d c)
                (.fill g2d sq)))))
        (.drawImage g vimg 0 0 this)
        )))]
    (do 
      (add-watch grid-ref :repaint (fn [_ _ _ _] (.repaint pnl)))
    pnl)))

(defn sim-button [grid-ref]
  (let [cb (JCheckBox. "Sim!")]
    (future
      (loop []
        (do
          (when (-> cb .isSelected)
            (dosync (ref-set grid-ref (conway.rules/step @grid-ref))))
          (Thread/sleep 33))
        (recur)))
    cb))

(defn step-button [grid-ref]
  (doto (JButton. "Step")
    (.addActionListener
      (reify ActionListener
        (actionPerformed [_ _]
          (dosync (ref-set grid-ref (conway.rules/step @grid-ref))))))))

(defn reset-button [grid-ref]
  (doto (JButton. "Reset")
    (.addActionListener
      (reify ActionListener
        (actionPerformed [_ _]
          (dosync (ref-set grid-ref (conway.rules/seed-grid 100 100))))))))

(defn run-app [exit-op] (let [grid-ref (ref (conway.rules/seed-grid 100 100))]
  (doto (JFrame. "Conway's Game of Life")
    (.setSize 800 600)
    (.setDefaultCloseOperation exit-op)
    (.add (panel grid-ref) BorderLayout/CENTER)
    (.add (doto (Box. BoxLayout/PAGE_AXIS)
            (.add (step-button grid-ref))
            (.add (sim-button grid-ref))
            (.add (reset-button grid-ref))) BorderLayout/SOUTH)
    (.setVisible true))))

;(run-app JFrame/DISPOSE_ON_CLOSE)

(defn -main
  [& args]
  (future (run-app JFrame/EXIT_ON_CLOSE)))
