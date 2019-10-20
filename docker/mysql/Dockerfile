FROM registry.cn-hangzhou.aliyuncs.com/elem-lihao/mysql:v1.0
ENV INIT_DIR /docker-entrypoint-initdb.d
COPY ./table.sql /tmp/table.sql
COPY ./init.sh $INIT_DIR/init.sh
RUN chmod +x $INIT_DIR/init.sh
