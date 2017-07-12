(ns sendgrid.alerts
  (:require [clj-http.client :as client]
            [clojure.data.json :refer [write-str]]
            [sendgrid.util :refer [url]]
            [environ.core :refer [env]]))

;;GET https://api.sendgrid.com/v3/alerts HTTP/1.1
(defn alerts
  [{api-token :api-token}]
  (client/get (str url "alerts")
              {:headers {:authorization api-token
                         :content-type :json}}))

;;POST https://api.sendgrid.com/v3/alerts HTTP/1.1

;;GET https://api.sendgrid.com/v3/alerts/{alert_id} HTTP/1.1

;;DELETE https://api.sendgrid.com/v3/alerts/{alert_id} HTTP/1.1

;;PATCH https://api.sendgrid.com/v3/alerts/{alert_id} HTTP/1.1
