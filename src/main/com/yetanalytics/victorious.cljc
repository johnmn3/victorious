(ns com.yetanalytics.victorious
  #?(:cljs (:require [reagent.core :as r]
                     [cljsjs.victory])
     :clj (:require [camel-snake-kebab.core :as csk]))
  #?(:cljs (:require-macros
            [com.yetanalytics.victorious :refer [defall-victory!]])))

;; Inline, def all the things
#?(:clj (defmacro defall-victory!
          []
          (let [defs (for [nm '["Tooltip"
                                "SelectionContainer"
                                "Container"
                                "Group"
                                "ZoomContainer"
                                "Theme"
                                "Bar"
                                "VoronoiContainer"
                                "Line"
                                "ClipContainer"
                                "Axis"
                                "Legend"
                                "ErrorBar"
                                "BrushContainer"
                                "Scatter"
                                "Candlestick"
                                "Chart"
                                "Transition"
                                "Portal"
                                "CursorContainer"
                                "SharedEvents"
                                "Animation"
                                "Pie"
                                "Area"
                                "PolarAxis"
                                "Voronoi"
                                "Label"
                                "Stack"]
                           :let [name-sym (csk/->kebab-case-symbol nm)]]
                       `(def ~name-sym
                          (reagent.core/adapt-react-class
                           ~(symbol "js" (str "Victory.Victory" nm)))))]
            `(do ~@defs)))
   :cljs (defonce defall (defall-victory!)))
