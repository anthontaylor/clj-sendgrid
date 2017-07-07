(ns sendgrid.util
  (:require [clj-http.client :as client]))

;;This works
(def API_TOKEN "Bearer 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")
(client/get "https://api.sendgrid.com/v3/templates" {:headers {:authorization API_TOKEN :content-type :json}})
