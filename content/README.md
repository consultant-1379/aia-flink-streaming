# Introduction
pbaName is flink streaming flow generated from the AIA Portal(http://analytics.ericsson.se/#/) using flink streaming template.

# Prerequisites

Please follow the guide http://analytics.ericsson.se/#/Documentation/Prepare_to_Build_and_Run to set up your environment. The following tools are required,
```
   Java
   Maven
   Docker

```
various services including Kafka, database, Flink are required with regards to the selected data sources, data sinks and processing engine.

You can use AIA Sandbox(http://analytics.ericsson.se/#/GetStarted/sandbox) for flow/application execution and testing.

# Build the application

## Implmentation

Please follow the instruction as in comments in the following class to implement driver logic,
```
  com.ericsson.component.aia.services.bps.flink.app.pbaNameInCamelCase
```

## Compile with Maven
```
mvn clean install
```

# Running pbaName

## Run the application locally

Run the following command,
```
java -jar target/aia-flink-streaming-deployable.jar <flow.xml path>
<flow.xml path>: flow xml location
```

## Run on standalone flink cluster

Run the following command to run flink job in cluster,
```
flink run -m <jobmanager-ip:port> target/aia-flink-streaming-deployable.jar  <flow.xml path>
<jobmanager-ip:port>: job manager interface
<flow.xml path>: flow xml location
```

## Run the application in docker

Dockerfile is provided to facilitate the creation of docker image and execute in docker mode.

### Containerize the application
Go to the pbaName project root folder and then run the following commands,
```
docker login -u <signum> http://armdocker.rnd.ericsson.se
docker build -t armdocker.rnd.ericsson.se/aia/bps-pbaName:1.0 .
```
### Publish the container to Artifactory
```
docker push armdocker.rnd.ericsson.se/aia/bps-pbaName:1.0
```
### Run Containerize application.
```
docker run --env mainClass=com.ericsson.component.aia.services.bps.flink.app.pbaNameInCamelCase --env masterUrl=<jobmanager-ip:port> --env flowPath=<flow.xml path> --env jobArguments="" armdocker.rnd.ericsson.se/aia/bps-pbaName:1.0
<jobmanager-ip:port>: job manager interface
<flow.xml path>: flow xml location
```

## verify output

As per the flow.xml verify data sink for expected result.
