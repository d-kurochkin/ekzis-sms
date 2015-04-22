(ns ekzis-sms.core
  (:gen-class))

(require '[clojure.xml :as xml])
(require '[clojure.zip :as zip])

(def service-url "https://mobizon.kz/service")
(def api-key "apiKey=XXX")
(def out-format "output=xml")

(def getownbalance-method  "/user/getownbalance")
(def sendsmsmessage-method "/message/sendsmsmessage")


(def balance-request (str  
                       service-url 
                       getownbalance-method "?"
                       out-format "&"
                       api-key))

(defn message-request 
  [recipient message]
  (str
    service-url
    sendsmsmessage-method "?"
    out-format "&"
    api-key "?"
    recipient "?"
    message))
                       
                      
(defn request-data
  [req]
  (:content (xml/parse req)))

(defn get-tag-content 
  [tag data]
  (->>
    (filter #(= tag (:tag %)) data)
    first
    :content))
 
(defn get-balance
  []
  (->>
    balance-request
    request-data
    (get-tag-content :data)
    (get-tag-content :balance)s
    first
    read-string))  

(defn -main
  []
  (println balance-request))
