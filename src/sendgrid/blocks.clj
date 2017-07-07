(ns sendgrid.blocks
  (:require [clj-http.client :as client]
            [clojure.data.json :refer [write-str]]
            [sendgrid.util :refer [url]]
            [environ.core :refer [env]]))

(defn blocks
  [{api-token :api-token}]
  (client/get (str url "suppression/blocks")
              {:headers {:authorization api-token
                         :content-type :json}}))
