(ns sendgrid.core-test
  (:require [clojure.test :refer :all]
            [clj-http.client :as client]
            [environ.core :refer [env]]
            [clojure.java.io :as io]
            [sendgrid.core :refer :all]))

(def params {:limit 1})
(def api-token (env :api-token))

(deftest test-environ
  (is (= false (nil? api-token)))
  (is (= false (nil? (env :from-email))))
  (is (= false (nil? (env :to-email)))))

(deftest test-alerts
  (is (= 200 (:status (get-alerts api-token)))))

(deftest test-bounces
  (is (= 200 (:status (get-bounces api-token))))
  (is (= 200 (:status (get-bounces api-token params)))))

(deftest test-blocks
  (is (= 200 (:status (get-blocks api-token))))
  (is (= 200 (:status (get-blocks api-token params)))))

(deftest test-invalid-emails
  (is (= 200 (:status (get-invalid-emails api-token))))
  (is (= 200 (:status (get-invalid-emails api-token params)))))

(deftest test-spam-reports
  (is (= 200 (:status (get-spam-reports api-token))))
  (is (= 200 (:status (get-spam-reports api-token params)))))

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
