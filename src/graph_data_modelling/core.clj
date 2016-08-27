(ns graph-data-modelling.core
  (:require [ubergraph.core :as uber]
            [ubergraph.alg :as alg]))

(def my-graph (uber/digraph [:a :b]))


(def airport
  (->
    (uber/multigraph
      [:chicago {:name "Chicago" :country "United States of America"}]

      [:new-york {:name "New York" :country "United States of America"}]

      [:AC702 {:code                    "AC702" :carrier "Air Canada" :duration 96 :source-airport-code "ORD"
               :destination-aiport-code "JFK" :departure 1130 :arrival 1226}]

      [:AA8203 {:code                "AA8203" :carrier "American Airlines" :duration 96
                :source-airport-code "ORD" :destination-aiport-code "EWR" :departure 1180
                :arrival             1136}]

      [:AA8204 {:code                "AA8204" :carrier "Air Canada" :duration 96
                :source-airport-code "ORD" :destination-aiport-code "JFK" :departure 1305
                :arrival             1200}]

      [:AC703 {:code                     "AC703" :carrier "Air Canada" :duration 96 :source-airport-code "ORD"
               :destination-aiport-cokde "JFK" :departure 50 :arrival 1380}])
    (uber/add-directed-edges
      [:chicago :AC702 {:flight :has-flight}]
      [:AC702 :new-york {:flight :flying-to}]
      [:chicago :AA8203 {:flight :has-flight}]
      [:AA8203 :new-york {:flight :flying-to}]
      [:new-york :AA8204 {:flight :has-flight}]
      [:new-york :AC703 {:flight :has-flight}]
      [:AA8204 :chicago {:flight :flying-to}]
      [:AC703 :chicago {:flight :flying-to}])))

(uber/pprint airport)
(alg/edges-in-path (alg/shortest-path airport {:start-node :chicago, :end-node :new-york}))
(alg/nodes-in-path (alg/shortest-path airport {:start-node :chicago, :end-node :new-york}))
(uber/viz-graph airport)

