(ns bob
  (:require [clojure.string :as str]))

(defn shouting? [input]
  (and
    (not= (str/lower-case input) input)
    (= (str/upper-case input) input)
  ))

(defn response-for [input] ;; <- arglist goes here
  (cond
    (str/blank? input) "Fine. Be that way!"
    (shouting? input) "Whoa, chill out!"
    (str/ends-with? input "?") "Sure."
    :else "Whatever.")
)
