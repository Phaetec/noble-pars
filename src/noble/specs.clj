(ns noble.specs
  (:require [clojure.spec.alpha :as s]))

(s/fdef noble.convert/vec->str
        :args (s/cat :vec vector?)
        :ret string?)

(s/fdef noble.convert/convert-type
        :args (s/cat :map map?)
        :ret string?)
