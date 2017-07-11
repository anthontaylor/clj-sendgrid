(ns sendgrid.core-test
  (:require [clojure.test :refer :all]
            [clj-http.client :as client]
            [sendgrid.util :refer [url string->b64-string]]
            [environ.core :refer [env]]
            [clojure.java.io :as io]
            [sendgrid.alerts :refer [alerts]]
            [sendgrid.email :refer [send-email]]
            [sendgrid.stats :refer [get-request]]))

(def params {:limit 1})
(def api-token (env :api-token))

(deftest test-environ
  (is (= false (nil? api-token)))
  (is (= false (nil? (env :from-email))))
  (is (= false (nil? (env :to-email)))))

(deftest test-alerts
  (is (= 200 (:status (alerts {:api-token api-token})))))

(deftest test-bounces
  (is (= 200 (:status (get-request api-token "bounces"))))
  (is (= 200 (:status (get-request api-token "bounces" params)))))

(deftest test-blocks
  (is (= 200 (:status (get-request api-token "blocks"))))
  (is (= 200 (:status (get-request api-token "blocks" params)))))

(deftest test-invalid-emails
  (is (= 200 (:status (get-request api-token "invalid_emails"))))
  (is (= 200 (:status (get-request api-token "invalid_emails" params)))))

(deftest test-spam-reports
  (is (= 200 (:status (get-request api-token "spam_reports"))))
  (is (= 200 (:status (get-request api-token "spam_reports" params)))))

(deftest test-emails
  (let [file-content (string->b64-string "Hello World!")]
    (is (= 202 (:status (send-email {:api-token api-token
                                     :from (env :from-email)
                                     :to (env :to-email)
                                     :subject "Test Subject"
                                     :message "Test Message"
                                     :filename "Test.txt"
                                     :content file-content})))))

  (is (= 202 (:status (send-email {:api-token api-token
                                   :from (env :from-email)
                                   :to (env :to-email)
                                   :subject "Test Subject"
                                   :message "Test Message"})))))
