(ns ekzis-sms.sms.service
  (:require [clojure.xml :as xml])
  (:require [clojure.zip :as zip]))

(def service-url "https://mobizon.kz/service")
(def api-key "apiKey=0336f1db764f13bba0357f854da66fea9633233a")
(def out-format "output=xml")

(def sendsmsmessage-method "/message/sendsmsmessage")

(def url-encode #(. java.net.URLEncoder encode %))

(defn request-data
  [req]
  (:content (xml/parse req)))

(defn get-tag-content 
  [tag data]
  (->>
    (filter #(= tag (:tag %)) data)
    first
    :content))