(ns luminus-cats.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[luminus-cats started successfully]=-"))
   :middleware identity})
