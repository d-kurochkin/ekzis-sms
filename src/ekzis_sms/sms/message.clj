(ns ekzis-sms.sms.message
  (:use ekzis-sms.sms.service))


(defn message-request 
  [recipient message]
  (str
    service-url
    sendsmsmessage-method "?"
    out-format "&"
    api-key "&"
    "recipient=" recipient "&"
    "text=" (url-encode  message)))