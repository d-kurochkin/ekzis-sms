(ns ekzis-sms.core
  (:use ekzis-sms.sms.balance
        ekzis-sms.sms.message
        ekzis-sms.sms.dir)
  (:gen-class))

(defn main-task
  []
  (let 
    [sms-file (get-next-file)]
    (when sms-file
      (send-message sms-file)
      (->> (get-balance) (write-balance)))))
  

(defn main-task-loop
  []
  (loop []
    (try
     (main-task)
     (catch Exception e (println (str "Exception: " (.getMessage e)))))
    (Thread/sleep 5000) 
    (recur)))
   
(defn start-main-task
  []
  (doto 
   (Thread. main-task-loop)
   ;(.setDaemon true)
   (.start)))

(defn -main
  []
  (start-main-task)
  (println "Start balance checking"))
