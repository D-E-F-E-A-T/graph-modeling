(ns graph-data-modelling.core
  (:require [ubergraph.core :as uber]))

(def my-graph (uber/digraph [:a :b]))


(def airport
  (uber/graph
    [:city {:name "Chicago" :country "United States of America"}]
    [:flight {:code "AC702" :carrier "Air Canada" :duration 96 :source-airport-code "ORD" :destination-aiport "JFK" :departure 1130 :arrival 1226}]
    [:city :flight]))

(uber/pprint airport)

