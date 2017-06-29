(ns noble.test.translator
  (:require [clojure.test :refer [deftest is are testing]]
            [clojure.spec.test.alpha :as stest]
            [noble.translator :as translator]))

(deftest vec->str
  (testing "Convert vector to string."
    (are [x y] (= x y)
      "iamgroot" (translator/vec->str [:iamgroot])
      "i amgroot" (translator/vec->str [:i :amgroot])
      "i am groot" (translator/vec->str [:i :am :groot]))))

(deftest convert-type
  (are [x y] (= x y)
    "whoami { name }" (translator/convert-type {:whoami [:name]})
    "razupaltuff { kangaroo penguin }" (translator/convert-type {:razupaltuff [:kangaroo :penguin]})))
