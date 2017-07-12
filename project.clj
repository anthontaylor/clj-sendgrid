(defproject clj-sendgrid "0.1.0"
  :description "A Clojure Library for the Sendgrid API v3"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :url "http://slaejae.com"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [ring/ring-core "1.6.1"]
                 [environ "1.1.0"]
                 [cheshire "5.7.1"]
                 [clj-http "3.6.1"]
                 [org.clojure/data.json "0.2.6"]
                 [org.clojure/data.codec "0.1.0"]]
  :plugins [[lein-environ "1.1.0"]
            [lein-cloverage "1.0.7-SNAPSHOT"]]
  :deploy-repositories [["releases" {:url "https://oss.sonatype.org/service/local/staging/deploy/maven2/"
                                     :creds :gpg}
                         "snapshots" {:url "https://oss.sonatype.org/content/repositories/snapshots/"
                                      :creds :gpg}]]
  :scm {:url "git@github.com:anthontaylor/clj-sendgrid.git"}
  :pom-addition [:developers [:developer
                              [:name "AJ Taylor"]
                              [:url "http://slaejae.com"]
                              [:email "info@slaejae.com"]
                              [:timezone "-5"]]])
