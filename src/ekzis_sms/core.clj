(ns ekzis-sms.core
  (:gen-class))

(use 'ekzis-sms.sms.balance)



                       

 

(defn -main
  []
  (println (get-balance)))
