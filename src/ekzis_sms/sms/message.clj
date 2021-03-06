(ns ekzis-sms.sms.message
  (:require [clojure.xml :as xml])
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

(defn send-message
  [sms-file]
  (let [data (parse-file sms-file)
        request (message-request data)
        response (xml/parse request)
        [res-code res-msg] (get-response-status response)]
    (println (str "Send message: " data " Result: " [res-code res-msg])) 
    (if 
      (or (= res-code 0) (= res-code 100))
      (do 
        (move-to-send sms-file) 
        true)
      (do 
        (move-to-err sms-file) 
        (println response)
        false))))
