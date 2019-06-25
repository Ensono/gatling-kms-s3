#!/bin/bash

echo "<html><head></head><body>" > gatling/index.html
echo "<center>" >> gatling/index.html
echo "<h2>Gatling Performance Report</h2>" >> gatling/index.html
echo "<h3>Choose one of the scenarios below to view its report</h3>" >> gatling/index.html

cd gatling
for directory in `ls  -d */`; do
  echo "<div><a href=\"${directory}index.html\">Simulation Scenario: ${directory%-*}</a></div><p/>" >> ../gatling/index.html
done

echo "</center></body></html>" >> ../gatling/index.html

cd ..