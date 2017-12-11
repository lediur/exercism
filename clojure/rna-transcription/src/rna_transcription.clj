(ns rna-transcription)

(defn transcribe [nucleotide]
  (case nucleotide
    \A \U
    \C \G
    \G \C
    \T \A
    (throw (AssertionError. "Invalid DNA String"))))

(defn to-rna [dna-str]
  (apply str (map transcribe dna-str)))
