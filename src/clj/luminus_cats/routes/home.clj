(ns luminus-cats.routes.home
  (:require [luminus-cats.layout :as layout]
            [compojure.core :refer [defroutes GET POST]]
            [ring.util.http-response :as response]
            [clojure.java.io :as io]
            [luminus-cats.db.core :as db]
            [bouncer.core :as b]
            [bouncer.validators :as v]
            [ring.util.response :refer [redirect]]))

(defn validate-cat [params]
  (first
    (b/validate
      params
      :name v/required
      :owner v/required
      :size v/required)))

(defn create-cat! [{:keys [params]}]
  (if-let [errors (validate-cat params)]
    (-> (response/found "/")
        (assoc :flash (assoc params :errors errors)))
    (do
      (db/create-cat!
        (assoc params :timestamp (java.util.Date.)))
      (response/found "/"))))

(defn delete-cat! [id]
  (do
    (db/delete-cat!)
    (response/found "/")))

(defn home-page [{:keys [flash]}]
  (layout/render
    "home.html"
    (merge {:cats (db/get-cats)}
           (select-keys flash [:name :owner :size :errors]))))

(defn about-page []
  (layout/render "about.html"))

(defroutes home-routes
  (GET "/" request (home-page request))
  (POST "/" request (create-cat! request))
  (GET "/about" [] (about-page)))
