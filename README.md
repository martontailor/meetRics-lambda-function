Lambda function for serverless metric reporting system.

This function sinks the events from SQS to DynamoDB.

To build spring native image on Mac you need to build the docker image and run
```
docker build -t "meetrics-lambda" .
```
```
docker run -dit -v `pwd`:`pwd` -w `pwd` -v ~/.m2:/root/.m2 meetrics-lambda
```
```
./mvnw clean -Pnative native:compile -DskipTests
```