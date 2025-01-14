FROM --platform=linux/x86_64 mysql:8.0

COPY initdb.d/base /docker-entrypoint-initdb.d/

COPY conf.d/* /etc/mysql/conf.d/
RUN chmod 644 /etc/mysql/conf.d/*.cnf