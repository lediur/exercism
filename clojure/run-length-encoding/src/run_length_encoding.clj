(ns run-length-encoding)

(defn parse-nonempty [s]
  (if (empty? s)
    1
    (Integer/parseInt s)))

(defn run-length-encode
  "encodes a string with run-length-encoding"
  [s]
  (->> (partition-by identity s)
       (mapcat (juxt count first))
       (remove #{1})
       (apply str)))

(defn run-length-decode
  "decodes a run-length-encoded string"
  [s]
  (->> (re-seq #"(\d*)([A-Za-z\s])" s)
       (mapcat (fn [[raw-match count char]] (repeat (parse-nonempty count) char)))
       (apply str)))