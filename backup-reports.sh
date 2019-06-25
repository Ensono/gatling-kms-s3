#!/bin/bash

timestamp=`date +%Y%m%d_%H%M%S`
reports_dir="/home/gatling_user/gatling-reports/$timestamp"

echo 'Backing up gatling report...'
mkdir "$reports_dir"
cp -r target/gatling/* "$reports_dir"
echo "Backed up gatling report in $reports_dir"