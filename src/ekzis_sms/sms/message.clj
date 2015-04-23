(ns ekzis-sms.sms.message
  (:use ekzis-sms.sms.service))

(defn parse-message
  [file]
  (let [data (get-xml-data file)
        attrs (get-tag-attrs :NOM data)
        {:keys [MKOD MNAIM]} attrs] 
    [MKOD MNAIM]))
        

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
  [recipient message]
  (println (message-request recipient message)))