[![Build Status](https://travis-ci.org/anthontaylor/clj-sendgrid.svg?branch=master)](https://travis-ci.org/anthontaylor/clj-sendgrid)
[![codecov](https://codecov.io/gh/anthontaylor/clj-sendgrid/branch/master/graph/badge.svg)](https://codecov.io/gh/anthontaylor/clj-sendgrid)

# clj-sendgrid
A Clojure Library for the  Sendgrid API v3

[![Clojars Project](http://clojars.org/clj-sendgrid/latest-version.svg)](https://clojars.org/clj-sendgrid)

## Usage
clj-sendgrid is available in Clojars. Add this ```:dependency``` to your Leiningen ```project.clj```:

```
[clj-sendgrid "0.1.2"]
```

Include in your namespace

```
(:require [sendgrid.core :as sg])
```

### Each request below requires an api-token
```
(def api-token "Bearer YOURTOKENVALUE")
```

```
(get-alerts api-token)

(get-bounces api-token)

(get-blocks api-token)

(get-invalid-emails api-token)

(get-spam-reports api-token)
```

### You can also add parameters as a map

```
(get-blocks api-token {:limit 1})
```

### Basic usage of sending an email
```
(send-email {:api-token api-token
             :from test@test.com
             :to abc@abc.com
             :subject "Test Subject"
             :message "Test Message"})
```
### Email can be sent to multiple recipients
```
(send-email {:api-token api-token
             :from test@test.com
             :to [abc@abc.com hello@abc.com]
             :subject "Test Subject"
             :message "Test Message"})
```

### Basic usage of sending an email with file content

```
(send-email {:api-token api-token
             :from test@test.com
             :to abc@abc.com
             :subject "Test Subject"
             :message "Test Message"
             :filename "Test.txt"
             :content (string->b64-string "Hello World)"})
```
### Sendgrid API
https://sendgrid.com/docs/API_Reference/Web_API_v3/index.html
