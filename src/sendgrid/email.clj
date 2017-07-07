(ns sendgrid.email
  (:require [clj-http.client :as client]
            [clojure.data.json :refer [write-str]]
            [environ.core :refer [env]]
            [sendgrid.util :refer [url]]))

(defn send-email
  [{:keys [from to subject message api-token]}]
  (client/post
   (str url "mail/send")
   {:content-type :json
    :headers {:authorization api-token}
    :body (write-str {:personalizations [{:to [{"email" to}]}]
                      :from    {"email" from}
                      :subject  subject
                      :content [{:type "text/html"
                                 :value  message}]})}))