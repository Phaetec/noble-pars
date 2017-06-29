(ns noble.translator)

(defn create-graphql
  "Takes clojure data and outputs a valid graphql query-string"
  [data]
  data)

(defn keys-to-string
  "Takes a collection and converts all keywords to strings."
  [coll]
  (map 
   #(if (coll? %)
      (keys-to-string %)
      (if (keyword? %)
       (name %)
       %))
   coll))
