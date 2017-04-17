(ns word-count-test
(:require [expectations :refer :all]
          [expectations.clojure.test :refer [defexpect]]
            word-count))

(defexpect count-one-word
  (expect {"word" 1}
         (word-count/word-count "word")))

(defexpect count-one-of-each
  (expect {"one" 1 "of" 1 "each" 1}
         (word-count/word-count "one of each")))

(defexpect count-multiple-occurrences
  (expect {"one" 1 "fexpecth" 4 "two" 1 "red" 1 "blue" 1}
         (word-count/word-count "one fexpecth two fexpecth red fexpecth blue fexpecth")))

(defexpect ignore-punctuation
  (expect {"car" 1, "carpet" 1 "as" 1 "java" 1 "javascript" 1}
         (word-count/word-count "car : carpet as java : javascript!!&@$%^&")))

(defexpect include-numbers
  (expect {"testing" 2 "1" 1 "2" 1}
         (word-count/word-count "testing, 1, 2 testing")))

(defexpect normalize-case
  (expect {"go" 3}
         (word-count/word-count "go Go GO")))
