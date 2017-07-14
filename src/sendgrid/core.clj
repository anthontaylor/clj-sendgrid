(ns sendgrid.core
  (:require [clj-http.client :as client]
            [clojure.data.json :refer [write-str]]
            [sendgrid.util :refer [url]]
            [environ.core :refer [env]]))

(defn alerts
  [{api-token :api-token}]
  (client/get (str url "alerts")
              {:headers {:authorization api-token
                         :content-type :json}}))

(defn send-email
  [{:keys [from to subject message api-token filename content]}]
  (let [json-body {:personalizations [{:to [{"email" to}]}]
                   :from    {"email" from}
                   :subject  subject
                   :content [{:type "text/html" :value  message}]}
        attachments (when (and filename content) {:attachments [{:filename filename :content content}]})
        request {:content-type :json
                 :headers {:authorization api-token}
                 :body (write-str (merge json-body attachments))}]
    (client/post (str url "mail/send") request)))

(defn get-request
  ([api-token name]
   (client/get (str url "suppression/" name) {:headers {:authorization api-token
                                                        :content-type :json}}))
  ([api-token name params]
   (client/get (str url "suppression/" name) (merge {:headers {:authorization api-token
                                                               :content-type :json}}
                                                    {:query-params params}))))
