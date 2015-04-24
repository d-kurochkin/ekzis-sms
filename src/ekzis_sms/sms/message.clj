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

(defn send-next-message
  []
  (let [sms-file (get-next-file)
        request (->> sms-file (parse-file) (message-request))
        response (xml/parse request)
        [res-code res-msg] (get-response-status response)]
    (println nil)))
