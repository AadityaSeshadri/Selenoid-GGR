#!/bin/bash

set -e


# Waiting for selenoid to start
#docker-compose exec dockerize dockerize -wait tcp://selenoid:4444 -timeout 60s

echo "#######################################################################"
# Run tests
docker pull selenoid/vnc:chrome_76.0
docker pull selenoid/video-recorder:latest-release
docker pull selenoid/vnc:opera_62.0

docker-compose exec seleniumcode mvn clean test

