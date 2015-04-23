(ns ekzis-sms.dir
  (:require [clojure.java.io :as io]))

(def directory (io/file "/home/pengo/Development/ekzis-sms/data/"))

(defn check-ekz
  [file]
  (.contains (str file) ".ekz"))

(defn get-next-file
  []
  (->>
    directory
    file-seq
    (filter check-ekz)
    first))
  
