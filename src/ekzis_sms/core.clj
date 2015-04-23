(ns ekzis-sms.core
  (:use ekzis-sms.sms.balance)
  (:gen-class))

(defn start-balance-task
  []
  (doto 
   (Thread. check-balance-loop)
   ;(.setDaemon true)
   (.start)))

(defn -main
  []
  (start-balance-task)
  (println "Start balance checking"))
