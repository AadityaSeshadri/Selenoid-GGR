from maven:alpine

copy ./ ./cucumber-jvm-template-master

workdir ./cucumber-jvm-template-master

EXPOSE 4444
#ENTRYPOINT ["mvn","test"]
CMD ["mvn", "test"]