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

; THREAD LAST

(->> (l.db/todos-os-pedidos)
     (group-by :usuario)
     vals
     (map count)
     println)

(defn conta-total-por-usuario
  [[usuario pedidos]]
  (println "Usuário" usuario "Pedidos" pedidos)
  (count pedidos))

(->> (l.db/todos-os-pedidos)
     (group-by :usuario)
     (map conta-total-por-usuario)
     println)

; Usando vetores não é recomendado pq fica uma contagem estranha

(defn conta-total-por-usuario
  [[usuario pedidos]]
  (println "Usuário" usuario "Pedidos" pedidos)
  [usuario (count pedidos)])
3

(->> (l.db/todos-os-pedidos)
     (group-by :usuario)
     (map conta-total-por-usuario)
     println)

; Usando mapas para retornar pois ficar mais elegante e mais legivel

(defn conta-total-por-usuario
  [[usuario pedidos]]
  (println "Usuário" usuario "Pedidos" pedidos)
  {:usuario-id usuario
   :total-de-pedidos (count pedidos)})

(->> (l.db/todos-os-pedidos)
     (group-by :usuario)
     (map conta-total-por-usuario)
     println)

(println "PEDIDOS")

(defn total-do-item
  [[_ detalhes]]
  (* (get detalhes :quantidade 0) (get detalhes :preco-unitario 0)))

(defn total-do-pedido
  [pedido]
  (->> pedido
    (map total-do-item)
    (reduce +)))

(defn total-dos-pedidos
  [pedidos]
  (->> pedidos
       (map :itens)
       (map total-do-pedido)
       (reduce +)))

(defn quantia-de-pedidos-e-gasto-total-por-usuario
  [[usuario pedidos]]
  (println "Usuário >>" usuario "Pedidos >>" pedidos)
  {:usuario-id usuario
   :total-de-pedidos (count pedidos)
   :preco-total (total-dos-pedidos pedidos)})

(->> (l.db/todos-os-pedidos)
     (group-by :usuario)
     (map quantia-de-pedidos-e-gasto-total-por-usuario)
     println)
