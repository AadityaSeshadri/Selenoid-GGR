#!/bin/bash

set -e


# Waiting for selenoid to start
#docker-compose exec dockerize dockerize -wait tcp://selenoid:4444 -timeout 60s

echo "#######################################################################"
# Run tests
rm -rf /tmp/target 
docker pull selenoid/vnc:chrome_76.0
docker pull selenoid/vnc:firefox_68.0
docker pull selenoid/vnc:opera_62.0
docker pull selenoid/video-recorder:latest-release


docker-compose exec seleniumcode mvn clean test

#Copy Results to Local 

docker cp cucumber-jvm-template-master_seleniumcode_1:/cucumber-jvm-template-master/target/ /private/tmp/target
docker cp cucumber-jvm-template-master_seleniumcode_1:/cucumber-jvm-template-master/ExecutionLog.log/ /private/tmp



