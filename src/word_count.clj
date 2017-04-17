(ns word-count
  (:require [clojure.string :refer [split, lower-case]]))

(defn sanitize [string]
  (re-seq #"[\w\d]+" (lower-case string)))

(defn word-count [input]
  (frequencies (sanitize input)))
