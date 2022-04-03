FROM openjdk:11

ARG ADDITIONAL_OPTS
ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

COPY /target/*.jar cat_collector_application.jar

SHELL ["/bin/sh", "-c"]

EXPOSE 8081

CMD java ${ADDITIONAL_OPTS} -jar cat_collector_application.jar