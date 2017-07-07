(ns sendgrid.alerts
  (:require [clj-http.client :as client]
            [clojure.data.json :refer [write-str]]
            [sendgrid.util :refer [url]]
            [environ.core :refer [env]]))

(defn alerts
  [{api-token :api-token}]
  (client/get (str url "alerts")
              {:headers {:authorization api-token
                         :content-type :json}}))
