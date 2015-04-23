(ns ekzis-sms.xml
  (:require [clojure.xml :as xml])
  (:require [clojure.zip :as zip]))


(defn get-xml-data
  [req]
  (:content (xml/parse req)))

(defn get-tag-content 
  [tag data]
  (->>
    (filter #(= tag (:tag %)) data)
    first
    :content))

(defn get-tag-attrs 
  [tag data]
  (->>
    (filter #(= tag (:tag %)) data)
    first
    :attrs))