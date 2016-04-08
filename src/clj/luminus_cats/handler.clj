(ns luminus-cats.handler
  (:require [compojure.core :refer [routes wrap-routes]]
            [luminus-cats.layout :refer [error-page]]
            [luminus-cats.routes.home :refer [home-routes]]
            [compojure.route :as route]
            [luminus-cats.middleware :as middleware]))

(def app-routes
  (routes
    (wrap-routes #'home-routes middleware/wrap-csrf)
    (route/not-found
      (:body
        (error-page {:status 404
                     :title "page not found"})))))

(def app (middleware/wrap-base #'app-routes))
