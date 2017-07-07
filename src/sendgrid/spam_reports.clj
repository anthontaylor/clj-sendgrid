(ns sendgrid.spam-reports
  (:require [clj-http.client :as client]
            [clojure.data.json :refer [write-str]]
            [sendgrid.util :refer [url]]
            [environ.core :refer [env]]))

(defn spam-reports
  [{api-token :api-token}]
  (client/get (str url "suppression/spam_reports")
              {:headers {:authorization api-token
                         :content-type :json}}))
