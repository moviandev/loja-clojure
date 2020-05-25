(ns loja.aula1)

; ["arr1", "arr2", "arr3"]
; { "age" 37, "person" 39 }
; '(1 2 3 4 5) lista ligada
; [[0 1]] ñ existe
; #{} conjuntos

; map
; reduce
; filter

; loop

(map println ["arr1", "arr2", "arr3"])
(println (first ["arr1", "arr2", "arr3"]))
(println (rest ["arr1", "arr2", "arr3"]))
(println (rest []))
(println (next ["arr1", "arr2", "arr3"]))
(println (next []))
(println (seq []))
(println (seq [1 3 4 5]))


(println "\n meu mapa looping infinito \n")
(defn meu-map
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (funcao primeiro)
    (meu-map funcao (rest sequencia))))

;(meu-map println ["arr1", "arr2", "arr3"])

(println "\n meu mapa com parada no false \n")

(defn meu-map
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if primeiro
      (do
        (funcao primeiro)
        (meu-map funcao (rest sequencia))))))

(meu-map println ["arr1", false, "arr3"])

(println "\n meu mapa com parada no nil \n")

(defn meu-map
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if (not (nil? primeiro))
      (do
        (funcao primeiro)
        (meu-map funcao (rest sequencia))))))

(meu-map println ["arr1", false, "arr3"])

