#!/bin/bash

set -e

docker pull selenoid/vnc:chrome_75.0
docker pull selenoid/video-recorder


# Waiting for selenoid to start
#docker-compose exec dockerize dockerize -wait tcp://selenoid:4444 -timeout 60s

# Run tests
docker-compose exec seleniumcode mvn test

