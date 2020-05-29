(ns loja.aula2)

; ["arr1" "arr2" "arr3" "arr4" "arr5" "arr6"]

(defn conta
  [total-ate-agora elementos]
  (recur (inc total-ate-agora) (rest elementos)))

; (println (conta 0 ["arr1" "arr2" "arr3" "arr4" "arr5" "arr6"])) <-- trava o REPL


(defn conta
  [total-ate-agora elementos]
  (if (next elementos)
    (recur (inc total-ate-agora) (rest elementos))
    (inc total-ate-agora)))

(println (conta 0 ["arr1" "arr2" "arr3" "arr4" "arr5" "arr6"]))
(println (conta 0 []))

(defn conta
  [total-ate-agora elementos]
  (if (seq elementos)
    (recur (inc total-ate-agora) (rest elementos))
    total-ate-agora))

(println (conta 0 ["arr1" "arr2" "arr3" "arr4" "arr5" "arr6"]))
(println (conta 0 []))

(defn conta
  ([elementos]
   (conta 0 elementos))
  ([total-ate-agora elementos]
  (if (seq elementos)
    (recur (inc total-ate-agora) (rest elementos))
    total-ate-agora)))

(println (conta ["arr1" "arr2" "arr3" "arr4" "arr5" "arr6"]))
(println (conta []))


(println "\n LOOPING")
(defn conta
  [elementos]
  (loop [total-ate-agora 0,
         elementos-restantes elementos]
    (if (seq elementos-restantes)
      (recur (inc total-ate-agora) (next elementos-restantes))
      total-ate-agora)))

(println (conta ["arr1" "arr2" "arr3" "arr4" "arr5" "arr6"]))
(println (conta []))

