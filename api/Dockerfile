FROM openjdk:11

ARG ADDITIONAL_OPTS
ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

COPY /target/*.jar cat_api_application.jar

SHELL ["/bin/sh", "-c"]

EXPOSE 8082

CMD java ${ADDITIONAL_OPTS} -jar cat_api_application.jar