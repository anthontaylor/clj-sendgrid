(ns sendgrid.core-test
  (:require [clojure.test :refer :all]
            [sendgrid.core :refer :all]
            [sendgrid.email :refer [send-email]]
            [sendgrid.alerts :refer [alerts]]
            [sendgrid.bounces :refer [bounces]]
            [sendgrid.blocks :refer [blocks]]
            [sendgrid.invalid-emails :refer [invalid-emails]]
            [sendgrid.spam-reports :refer [spam-reports]]
            [clj-http.client :as client]
            [sendgrid.util :refer [url]]
            [environ.core :refer [env]]))

(deftest test-env
  "Verify that environ Variables are working"
  (is (= false (nil?  (env :api-token))))
  (is (= false (nil?  (env :from-email))))
  (is (= false (nil?  (env :to-email)))))

(deftest test-alerts
  (is (= 200 (:status (alerts {:api-token (env :api-token)})))))

(deftest test-bounces
  (is (= 200 (:status (bounces {:api-token (env :api-token)})))))

(deftest test-blocks
  (is (= 200 (:status (blocks {:api-token (env :api-token)})))))

(deftest test-invalid-emails
  (is (= 200 (:status (invalid-emails {:api-token (env :api-token)})))))

(deftest test-spam-reports
  (is (= 200 (:status (spam-reports {:api-token (env :api-token)})))))

(deftest test-email
  (is (= 202 (:status (send-email {:api-token (env :api-token)
                                   :from (env :from-email)
                                   :to (env :to-email)
                                   :subject "Test Subject"
                                   :message "Test Message"})))))
