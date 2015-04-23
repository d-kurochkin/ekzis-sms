(ns ekzis-sms.sms.dir
  (:use ekzis-sms.xml)
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(import '(java.io File))

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

(defn move-file
  [file]
  (let [file_path (str file)
        file_name (last (str/split file_name #"/"))
        out_path  (str output-directory "/" file_name)]
    (.renameTo (File. file_path) (File. out_path))))
    
  
(defn parse-file
  [file]
  (let [data (get-xml-data file)
        attrs (get-tag-attrs :NOM data)
        {:keys [MKOD MNAIM]} attrs] 
    [MKOD MNAIM]))

