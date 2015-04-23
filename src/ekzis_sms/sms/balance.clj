(ns ekzis-sms.sms.balance
  (:use ekzis-sms.sms.service))

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
    request-data
    (get-tag-content :data)
    (get-tag-content :balance)
    first
    read-string))  

(defn check-balance-loop
  []
  (loop []
    (Thread/sleep 5000)
    (println (get-balance))
    (recur)))
