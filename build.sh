#!/usr/bin/env bash
mvn clean package
cp ./target/blog.jar ./docker/java/
