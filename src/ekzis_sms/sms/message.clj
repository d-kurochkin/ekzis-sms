(ns ekzis-sms.sms.message
  (:use ekzis-sms.sms.service
        ekzis-sms.sms.dir
        ekzis-sms.xml))
        
(defn message-request 
  [[recipient message]]
  (str
    service-url
    sendsmsmessage-method "?"
    out-format "&"
    api-key "&"
    "recipient=" recipient "&"
    "text=" (url-encode  message)))

(defn send-next-message
  []
  (println (->> 
             (get-next-file)  
             (parse-file) 
             (message-request))))