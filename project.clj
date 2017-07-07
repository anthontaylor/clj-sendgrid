(defproject sendgrid "0.1.0"
  :description "A Clojure Library for the Sendgrid API v3"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [ring/ring-core "1.6.1"]
                 [environ "1.1.0"]
                 [cheshire "5.7.1"]
                 [clj-http "3.6.1"]
                 [org.clojure/data.json "0.2.6"]
                 [org.clojure/data.codec "0.1.0"]]
:plugins [[lein-environ "1.1.0"]])
