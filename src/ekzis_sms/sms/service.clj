(ns ekzis-sms.sms.service)

(def service-url "https://mobizon.kz/service")
(def api-key "apiKey=0336f1db764f13bba0357f854da66fea9633233a")
(def out-format "output=xml")

(def sendsmsmessage-method "/message/sendsmsmessage")

(def url-encode #(. java.net.URLEncoder encode %))
