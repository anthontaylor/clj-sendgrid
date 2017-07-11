(ns sendgrid.stats
  (:require [clj-http.client :as client]
            [clojure.data.json :refer [write-str]]
            [sendgrid.util :refer [url]]
            [environ.core :refer [env]]))

;;blocks

(defn blocks
  [{api-token :api-token}]
  (client/get (str url "suppression/blocks")
              {:headers {:authorization api-token
                         :content-type :json}}))

;;bounces

(defn bounces
  [{api-token :api-token}]
  (client/get (str url "suppression/bounces")
              {:headers {:authorization api-token
                         :content-type :json}}))

;;invalid-emails

(defn invalid-emails
  [{api-token :api-token}]
  (client/get (str url "suppression/invalid_emails")
              {:headers {:authorization api-token
                         :content-type :json}}))

;;spam-reports

(defn spam-reports
  [{api-token :api-token}]
  (client/get (str url "suppression/spam_reports")
              {:headers {:authorization api-token
                         :content-type :json}}))

;;sub-users

(defn sub-users [])
