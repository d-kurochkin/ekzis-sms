(ns ekzis-sms.sms.dir
  (:use ekzis-sms.xml)
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
  
(defn parse-message
  [file]
  (let [data (get-xml-data file)
        attrs (get-tag-attrs :NOM data)
        {:keys [MKOD MNAIM]} attrs] 
    [MKOD MNAIM]))
        


        