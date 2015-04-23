(ns ekzis-sms.sms.dir
  (:use ekzis-sms.xml)
  (:require [clojure.java.io :as io]))

(def input-directory (io/file "/home/pengo/Development/ekzis-sms/data/in"))
(def output-directory (io/file "/home/pengo/Development/ekzis-sms/data/out"))


(defn check-ekz
  [file]
  (.contains (str file) ".ekz"))

(defn get-next-file
  []
  (->>
    input-directory
    file-seq
    (filter check-ekz)
    first))
  


(defn parse-file
  [file]
  (let [data (get-xml-data file)
        attrs (get-tag-attrs :NOM data)
        {:keys [MKOD MNAIM]} attrs] 
    [MKOD MNAIM]))

