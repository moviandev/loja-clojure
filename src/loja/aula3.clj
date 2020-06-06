(ns loja.aula3
   (:require [loja.db :as l.db]))

(println (l.db/todos-os-pedidos))

(println (group-by :usuario (l.db/todos-os-pedidos)))

(defn minha-funcao-de-agrupamento
  [elemento]
  (println "elemento" elemento)
  (:usuario elemento))

(println (group-by
           minha-funcao-de-agrupamento (l.db/todos-os-pedidos)))

; { 15 []
;   1 []
;   10 [] }

(println "vals" (vals (group-by :usuario (l.db/todos-os-pedidos))))

(println "vals and count" (count
                            (vals
                              (group-by :usuario (l.db/todos-os-pedidos)))))

(println "vals, count and map" (map count
                               (vals (group-by :usuario (l.db/todos-os-pedidos)))))
