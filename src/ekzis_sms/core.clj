(ns ekzis-sms.core
  (:use ekzis-sms.sms.balance)
  (:gen-class))

(defn -main
  []
  (println (get-balance)))
