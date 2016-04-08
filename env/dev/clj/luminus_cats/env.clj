(ns luminus-cats.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [luminus-cats.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[luminus-cats started successfully using the development profile]=-"))
   :middleware wrap-dev})
