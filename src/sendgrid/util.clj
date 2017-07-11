(ns sendgrid.util
  (:require [clj-http.client :as client]
            [clojure.data.json :refer [write-str]]
            [clojure.java.io :as io]
            [clojure.data.codec.base64 :as b64]
            [environ.core :refer [env]]))

(def url "https://api.sendgrid.com/v3/")

(defn string->b64-string [original]
  (String. (b64/encode (.getBytes original)) "UTF-8"))
