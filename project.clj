(defproject noble "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0-alpha17"]]
  :plugins [[lein-ancient "0.6.10"]
            [lein-kibit "0.1.5"]
            [jonase/eastwood "0.2.4"]]
  :profiles {:dev {:dependencies [[org.clojure/test.check "0.9.0"]
                                  [org.clojure/data.json "0.2.6"]
                                  [clj-http "3.6.1"]]}})
