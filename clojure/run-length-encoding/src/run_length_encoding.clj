(ns run-length-encoding)

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
  (->> (re-seq #"(\d+)?([A-Za-z\s])" s)
       (mapcat (fn [[raw-match count char]]
         (repeat ((fnil read-string "1") count) char)))
       (apply str)))