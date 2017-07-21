(ns noble.translator
  (:require [clojure.walk :as walk]
            [clojure.string :as string]))

(defn arguments->string
  [argument-map]
  (let [stringified (walk/stringify-keys argument-map)
        mapped (map (fn [[k v]] (format "%s: %s" (str k) (str v))) stringified)]
    (format "(%s)" (string/join ", " mapped))))

(arguments->string {:id 3 :unit "meter"})

(defn vector->string
  [vector-data]
  (format "{%s}" (string/join (map #(element->string %) vector-data))))

(defn element->string
  [element]
  (if (keyword? element)
    (str " " (name element))
    (if (map? element)
      (arguments->string element)
      (if (vector? element)
        (vector->string element)
        element))))

(defn edn->graphql
  "Takes clojure data and outputs a valid graphql query-string."
  [data]
  (format "{%s}" (string/join (map element->string data))))

;; (edn->graphql [:foo :bar{:id 3} [:baz :chewbacca [:hairy :han [:bleh]]]])
;; [:foo :bar [:baz [:chewbacca]]] => "{foo bar {baz {chewbacca}}}"

;; [:foo {:id 3 :unit "meter"} [:bar [:chewbacca {:type "hairy"}]]]
;; => "{foo(id: 3, unit: "meter") {bar {chewbacca(type: "hairy")}}}"
