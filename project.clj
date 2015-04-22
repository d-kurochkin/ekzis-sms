(defproject ekzis-sms "0.0.1-SNAPSHOT"
  :description "FIXME: write description"
  :dependencies [
                 [org.clojure/clojure "1.6.0"]
                 [org.clojure/data.xml "0.0.8"]]
  :javac-options ["-target" "1.6" "-source" "1.6" "-Xlint:-options"]
  :aot [ekzis-sms.core]
  :main ekzis-sms.core)
