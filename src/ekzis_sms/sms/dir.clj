(ns ekzis-sms.sms.dir
  (:use ekzis-sms.xml)
  (:require [clojure.java.io :as io]
            [clojure.string :as str]
            [clojure.xml :as xml]))

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
        file_name (last (str/split file_path #"/"))
        out_path  (str output-directory "/" file_name)]
    (.renameTo (File. file_path) (File. out_path))))
    
  
(defn parse-file
  [file]
  (let [data (xml/parse file)
        attrs (get-tag-attrs :SMS [data])
        {:keys [NOM_MKOD MNAIM]} attrs] 
    [NOM_MKOD MNAIM]))


