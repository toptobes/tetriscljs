(defproject tetriscljs "0.0.0"
  :dependencies
  [[thheller/shadow-cljs "2.11.18" :classifier "aot"] [reagent "1.1.1" :exclusions [com.cognitect/transit-java org.clojure/clojure thheller/shadow-cljs org.clojure/clojurescript com.cognitect/transit-clj org.clojure/core.async]] [binaryage/devtools "1.0.2" :exclusions [com.cognitect/transit-java org.clojure/clojure thheller/shadow-cljs org.clojure/clojurescript com.cognitect/transit-clj org.clojure/core.async]]]

  :source-paths
  ["src/main"]

  :test-paths
  ["src/test"])