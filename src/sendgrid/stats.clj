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
