(ns sendgrid.stats
  (:require [clj-http.client :as client]
            [clojure.data.json :refer [write-str]]
            [sendgrid.util :refer [url]]
            [environ.core :refer [env]]))

(defn get-request
  ([api-token name]
   (client/get (str url "suppression/" name) {:headers {:authorization api-token
                                                        :content-type :json}}))
  ([api-token name params]
   (client/get (str url "suppression/" name) (merge {:headers {:authorization api-token
                                                               :content-type :json}}
                                                    {:query-params params}))))

(defn delete-request [])

;;Global

;;GET https://api.sendgrid.com/v3/stats?start_date=2015-01-01&end_date=2015-01-02 HTTP/1.1

;;Category

;;GET https://api.sendgrid.com/v3/categories/stats?start_date=2015-01-01&end_date=2015-01-02&categories=cat1&categories=cat2 HTTP/1.1

;;GET /v3/categories/stats/sums?start_date={start_date}&end_date={end_date}&aggregated_by={aggregated_by}&sort_by_metric={sort_by_metric}&sort_by_direction={sort_by_direction}&limit={limit}&offset={offset} HTTP/1.1
