(ns sendgrid.util
  (:require [clj-http.client :as client]
            [clojure.data.json :refer [write-str]]
            [environ.core :refer [env]]))

(def url "https://api.sendgrid.com/v3/")
