(ns anagram
    (require [clojure.string :as str]))

(defn anagram-checker [normed sorted]
    (fn [candidate]
        (let [normed-candidate (str/lower-case candidate)]
            (and
                (= (sort normed-candidate) sorted)
                (not= normed-candidate normed)))))

(defn anagrams-for [word candidates]
    (let [normed-word (str/lower-case word)
          sorted-word (sort normed-word)
          anagram? (anagram-checker normed-word sorted-word)]
        (filter anagram? candidates)))
