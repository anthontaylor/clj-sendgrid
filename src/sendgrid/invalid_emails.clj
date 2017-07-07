(ns sendgrid.invalid-emails
  (:require [clj-http.client :as client]
            [clojure.data.json :refer [write-str]]
            [sendgrid.util :refer [url]]
            [environ.core :refer [env]]))

(defn invalid-email<s
  [{api-token :api-token}]
  (client/get (str url "suppression/invalid_emails")
              {:headers {:authorization api-token
                         :content-type :json}}))
