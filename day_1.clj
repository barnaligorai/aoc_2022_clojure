(ns user
  (:require [clojure.string :as cstr]))

(def input (slurp "day_1_input.txt"))

(defn parse [raw-input]
  (->> (cstr/split raw-input #"\n\n") 
       (map (comp (partial map read-string) 
                  (partial cstr/split-lines)))))

(defn parse [raw-input]
  (->> (cstr/split-lines raw-input)
       (partition-by empty?)
       (take-nth 2)
       (map #(map read-string %))
       (map #(apply + %1))))


;; solution part 1,, the Elf carrying the most Calories
(apply max-key max (parse input))

;; solution part 2,, the top three Elves carrying the most Calories
(apply + (take 3 (sort > (parse input))))
