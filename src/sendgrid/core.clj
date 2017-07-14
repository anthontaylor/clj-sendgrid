(ns sendgrid.core
  (:require [clj-http.client :as client]
            [clojure.data.json :refer [write-str]]
            [clojure.data.codec.base64 :as b64]
            [environ.core :refer [env]]))

(def url "https://api.sendgrid.com/v3/")

(defn string->b64-string [original]
  (String. (b64/encode (.getBytes original)) "UTF-8"))

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

(defn get-alerts
  [api-token]
  (client/get (str url "alerts")
              {:headers {:authorization api-token
                         :content-type :json}}))

(defn get-bounces
  ([api-token]
   (client/get (str url "suppression/bounces") {:headers {:authorization api-token
                                                          :content-type :json}}))
  ([api-token params]
   (client/get (str url "suppression/bounces") (merge {:headers {:authorization api-token
                                                                 :content-type :json}}
                                                      {:query-params params}))))

(defn get-blocks
  ([api-token]
   (client/get (str url "suppression/blocks") {:headers {:authorization api-token
                                                         :content-type :json}}))
  ([api-token params]
   (client/get (str url "suppression/blocks") (merge {:headers {:authorization api-token
                                                                :content-type :json}}
                                                     {:query-params params}))))

(defn get-invalid-emails
  ([api-token]
   (client/get (str url "suppression/invalid_emails") {:headers {:authorization api-token
                                                                 :content-type :json}}))
  ([api-token params]
   (client/get (str url "suppression/invalid_emails") (merge {:headers {:authorization api-token
                                                                        :content-type :json}}
                                                             {:query-params params}))))

(defn get-spam-reports
  ([api-token]
   (client/get (str url "suppression/spam_reports") {:headers {:authorization api-token
                                                               :content-type :json}}))
  ([api-token params]
   (client/get (str url "suppression/spam_reports") (merge {:headers {:authorization api-token
                                                                      :content-type :json}}
                                                           {:query-params params}))))
