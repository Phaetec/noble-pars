(ns noble.test.convert
  (:require [clojure.test :refer [deftest is are testing]]
            [clojure.spec.test.alpha :as stest]
            [noble.convert :as convert]))

(deftest vec->str
  (testing "Convert vector to string."
    (are [x y] (= x y)
      "iamgroot" (convert/vec->str [:iamgroot])
      "i amgroot" (convert/vec->str [:i :amgroot])
      "i am groot" (convert/vec->str [:i :am :groot]))))

(deftest convert-type
  (are [x y] (= x y)
    "whoami { name }" (convert/convert-type {:whoami [:name]})
    "razupaltuff { kangaroo penguin }" (convert/convert-type {:razupaltuff [:kangaroo :penguin]})))
