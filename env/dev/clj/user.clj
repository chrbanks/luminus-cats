(ns user
  (:require [mount.core :as mount]
            luminus-cats.core))

(defn start []
  (mount/start-without #'luminus-cats.core/repl-server))

(defn stop []
  (mount/stop-except #'luminus-cats.core/repl-server))

(defn restart []
  (stop)
  (start))


