(ns ekzis-sms.core
  (:gen-class))


(def service-url "https://mobizon.kz/service")

(def balance-method "/user/getownbalance")

(def api-key "apiKey=XXXXXXXXXXXXXX")

(def out-format "output=xml")
  
(def balance-request (str  
                       service-url 
                       balance-method "?"
                       out-format "&"
                       api-key))

(defn -main
  []
  (println balance-request))
