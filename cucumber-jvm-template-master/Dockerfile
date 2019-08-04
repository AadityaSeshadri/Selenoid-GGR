from maven:alpine

copy ./ ./cucumber-jvm-template-master

workdir ./cucumber-jvm-template-master

RUN mvn clean compile

CMD [ "/bin/sh", "-c", "while sleep 3600; do :; done"]
