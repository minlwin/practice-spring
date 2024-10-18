FROM postgres:alpine

RUN apk update && apk add --no-cache tzdata

ENV POSTGRES_DB=distance
ENV POSTGRES_USER=distance
ENV POSTGRES_PASSWORD=distance

COPY init-earthdistance.sh /docker-entrypoint-initdb.d/

EXPOSE 5432/tcp