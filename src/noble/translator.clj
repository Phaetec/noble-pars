(ns noble.translator)

(defn keywords->string
  "Takes a collection and converts all keywords to strings."
  [coll]
  (map
   #(if (coll? %)
      (keywords->string %)
      (if (keyword? %)
       (name %)
       %))
   coll))

(defn collection->string
  "Takes a prepared collection of statements and converts them into graphql syntax."
  [coll]
  (str "{" (apply str (map #(str " " (if (coll? %)
                                       (collection->string %)
                                       (str %)))
                           coll)) "}"))

(defn edn->graphql
  "Takes clojure data and outputs a valid graphql query-string."
  [data]
  (->> data
       keywords->string
       collection->string
       (str "query ")))
;; (edn->graphql {:foo [:bar]})

;; [:foo :bar [:baz [:chewbacca]]] => "{foo bar {baz {chewbacca}}}"

;; [:foo {:id 3 :unit "meter"} [:bar [:chewbacca {:type "hairy"}]]]
;; => {foo(id: 3, unit: "meter") {bar {chewbacca(type: "hairy")}}}
