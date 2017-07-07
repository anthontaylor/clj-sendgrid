(ns sendgrid.bounces
  (:require [clj-http.client :as client]
            [clojure.data.json :refer [write-str]]
            [sendgrid.util :refer [url]]
            [environ.core :refer [env]]))

(defn bounces
  [{api-token :api-token}]
  (client/get (str url "suppression/bounces")
              {:headers {:authorization api-token
                         :content-type :json}}))
