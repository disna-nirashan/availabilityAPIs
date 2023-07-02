FROM amazoncorretto:11

RUN mkdir "/app"
WORKDIR "/app"

COPY target/availabilityAPIs.jar /app/

ENTRYPOINT [ "java", "-jar", "/app/availabilityAPIs.jar"  ]