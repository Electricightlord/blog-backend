#!/bin/bash
./build.sh
source ./env.sh
docker-compose -f ./docker/docker-compose.yaml up --build
