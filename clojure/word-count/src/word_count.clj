(ns word-count
  (require [clojure.string :as str]))

(defn word-count [words]
  (->> (str/split (str/lower-case words) #"[^\w]+")
       (frequencies)))
