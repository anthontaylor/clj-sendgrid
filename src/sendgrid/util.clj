(ns sendgrid.util
  (:require [clj-http.client :as client]
            [clojure.data.json :refer [write-str]]
            [environ.core :refer [env]]))

(def test-map {:from (env :from-email)
               :to (env :to-email)
               :subject "From the Repl"
               :message "Wowzas"})

(defn test-request
  []
  (let [url "https://api.sendgrid.com/v3/templates"]
    (client/get url {:headers {:authorization (env :api-token)
                               :content-type :json}})))

(defn send-email
  [{:keys [from to subject message]}]
  (let [url "https://api.sendgrid.com/v3/mail/send"]
    (client/post url {:content-type :json
                      :headers {:authorization (env :api-token)}
                      :body (write-str {:personalizations [{:to [{"email" to}]}]
                                        :from    {"email" from}
                                        :subject  subject
                                        :content [{:type "text/html"
                                                   :value  message}]})})))
