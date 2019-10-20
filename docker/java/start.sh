#!/bin/bash
while ! nc -z ${MYSQL_HOST} ${MYSQL_PORT};
do sleep 3;
done
echo "数据库启动完成"
java -jar /tmp/blog.jar