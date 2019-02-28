FROM kinggooo/jre
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} app.jar
#RUN bash -c 'touch /app.jar'
EXPOSE 9090
ENTRYPOINT ["java","-jar","app.jar"]
