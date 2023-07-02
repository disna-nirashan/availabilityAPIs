#!/bin/bash

export JAVA_HOME=/home/chandika/.jdks/corretto-11.0.19
mvn clean package

docker build -f Dockerfile -t avail-api:latest .

docker run --env-file env-vars-local -p 127.0.0.1:9090:8080 avail-api:latest