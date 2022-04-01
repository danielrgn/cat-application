FROM openjdk:11

ARG PROFILE
ARG ADDITIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

WORKDIR /opt/cat_application_consumer

COPY /target/*.jar cat_application_consumer.jar

SHELL ["/bin/sh", "-c"]

EXPOSE 8081

CMD java ${ADDITIONAL_OPTS} -jar cat_application_consumer.jar --spring.profiles.active=${PROFILE}