ENV_NAME=$1


cd target/gatling
for directory in `ls -d *`; do
  echo ${directory}
  new_name=`echo "${directory}" | grep -Po '(?<=).*(?=(-))'`
  mv -f "$directory" "${new_name}"
done