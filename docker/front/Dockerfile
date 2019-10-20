FROM nginx:latest
COPY ./nginx.conf /etc/nginx/conf.d
RUN rm /etc/nginx/conf.d/default.conf
COPY ./build /www/build
CMD nginx && tail -f /var/log/nginx/access.log