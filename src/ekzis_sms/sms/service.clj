(ns ekzis-sms.sms.service
  (:use ekzis-sms.xml))

(def service-url "https://mobizon.kz/service")
(def api-key "apiKey=0336f1db764f13bba0357f854da66fea9633233a")
(def out-format "output=xml")

(def sendsmsmessage-method "/message/sendsmsmessage")

(def url-encode #(. java.net.URLEncoder encode %))

(defn get-response-code
  [response]
  (->> 
    response
    :content
    (get-tag-content :code)
    first
    read-string))

(defn get-response-msg
  [response] 
  (->> 
    response
    :content
    (get-tag-content :msg)))

(defn get-response-status
  [response]
  [(get-response-code response)
   (get-response-code response)])