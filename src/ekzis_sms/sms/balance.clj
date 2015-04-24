(ns ekzis-sms.sms.balance
  (:use ekzis-sms.xml)
  (:use ekzis-sms.sms.service))

(def balance-timeout 60000)

(def getownbalance-method  "/user/getownbalance")
(def balance-request (str  
                       service-url 
                       getownbalance-method "?"
                       out-format "&"
                       api-key))

(defn get-balance
  []
  (->>
    balance-request
    get-xml-data
    (get-tag-content :data)
    (get-tag-content :balance)
    first
    read-string))
