(ns libpython-clj-play.core
  (:gen-class)
  (:require [libpython-clj.require :refer [require-python]]
            [libpython-clj.python :as py :refer [py. py.. py.-]]))

(require-python '[nltk :as nltk])
;(nltk/download "book")
(require-python '[nltk.book :as book])
;(count (py.- book/text3 tokens))
(defn lexical-diversity [text]
  #_{:clj-kondo/ignore [:unresolved-symbol]}
  (let [tokens (py.- text tokens)]
    (/ (-> tokens set count)
       (* 1.0 (count tokens)))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!" (lexical-diversity book/text3)))
