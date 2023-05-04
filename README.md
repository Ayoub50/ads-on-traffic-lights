## Project Description
This project is built only for training purposes.
The initial idea was to use Apache Kafka and create something that can make the most of its potential.
So one possible real implementation is a system that, based on traffic light colors, displays different advertisements on billboards placed near the traffic light. This is to ensure that drivers at the traffic light can be entertained by advertising.

### Basic implemementation description

The project has been implemented using Java, relying on Spring Boot as a framework. The reason for choosing Spring Boot is its lightweight nature and the convenience of having an integrated Tomcat server. The real-time data streaming platform Apache Kafka is utilized, owing to its ability to separate clients into consumers and producers. As such, we will have producers responsible for the management and maintenance of various traffic sensors, such as traffic light colors or pedestrian reservation buttons. Moreover, they will also be tasked with managing electronic billboards that display different advertisements. On the other hand, consumers will be responsible for processing data from the various sensors to display relevant advertisements.

Multiple endpoints will be created to gather information about traffic, as well as different endpoints to cater to the needs of consumers, such as displaying an advertisement on a billboard.

Therefore, the idea is to make the application horizontally scalable with various replicable and enableable modules, based on the needs of consumers and producers.

### Real life implementation

In a real-world deployment scenario, the following components will be involved:

1. Traffic Light Sensors: These devices are responsible for detecting the current state of traffic lights (red, yellow, or green) and publishing this information to the Kafka cluster. They act as producers within the system.

2. Advertisement Panels: These digital displays are strategically placed near traffic lights to showcase advertisements. They receive data from the Kafka cluster, which instructs them on which ads to display based on the traffic light state and other contextual factors. These panels serve as consumers within the system.

The Spring Boot back-end application has the following responsibilities:

- Receiving data from traffic light sensors (producers).
- Processing this data, potentially combining it with additional information (e.g., advertisement preferences, location-based targeting, etc.).
- Publishing the processed data to the Kafka cluster.
- Subscribing to the relevant Kafka topics to obtain the processed data and transmitting it to the advertisement panels (consumers).

The Spring Boot application and Kafka service can be deployed on cloud platforms such as AWS, Azure, or Google Cloud, or on-premises using dedicated hardware. Container orchestration tools like Kubernetes can be employed to manage and scale the instances of the Spring Boot application based on traffic and load.

In this configuration, the traffic light sensors and advertisement panels communicate with the Spring Boot application and Kafka service to exchange data. This architecture facilitates a scalable and fault-tolerant system capable of handling a large number of sensors and panels distributed across various locations.

## How to install the project as a systemd unit on a linux machine 

### Create a systemd unit file 

- filename: ads-on-traffic-lights.service
- location: /usr/lib/systemd/system/

```service
[Unit]
Description=Java Spring Boot project for ads management based on traffic lights
After=network.target

[Service]
User=troller
WorkingDirectory=/opt/JavaProjects/AdsOnTrafficLights
ExecStart=/usr/bin/java -jar /opt/JavaProjects/AdsOnTrafficLights/ads-on-traffic-lights.jar
SuccessExitStatus=143
TimeoutStopSec=10
Restart=on-failure

[Install]
WantedBy=multi-user.target
```

Pls note that the "WorkingDirectory" and "ExecStart" paths may differ.

### reload systemd configuration commands

```sh
sudo systemctl daemon-reload
```

### enable service

```sh
sudo systemctl enable ads-on-traffic-lights.service
```

### disable service

```sh
sudo systemctl disable ads-on-traffic-lights.service
```

### commands for managing and monitoring the service

#### start the service
```sh
sudo systemctl start ads-on-traffic-lights.service
```

#### stop the service 
```sh
sudo systemctl stop ads-on-traffic-lights.service
```

#### monitor status 
- Using systemctl 
```sh
sudo systemctl status ads-on-traffic-lights.service
```

- Using journalctl 
```sh
sudo journalctl -u ads-on-traffic-lights.service -f
```
#### restart service
```sh
sudo systemctl restart ads-on-traffic-lights.service
```

### Create Java Spring Boot configuration file 

- filename: ads-on-traffic-lights.conf
- location: the same as the jar file

```conf
spring.profiles.active=dev
```

## Set up a docker container for Kafka and Zookeeper

Zookeeper and Kafka are used together to create a distributed messaging system. Zookeeper is a centralized service that maintains configuration information, provides distributed synchronization, and handles coordination between distributed services like Kafka. Kafka is a distributed streaming platform used for building real-time data pipelines and streaming applications.

In this setup:

- Zookeeper is responsible for managing the Kafka cluster's metadata, including topics, partitions, and replicas. It ensures that the Kafka brokers are in sync and provides fault tolerance and high availability for the Kafka cluster.

- Kafka is used for publishing and subscribing to streams of records, like a message queue or enterprise messaging system. It is designed for high throughput, fault tolerance, and horizontal scalability.

By deploying both services in separate containers, you can create a local development environment that simulates a distributed system. This allows you to develop and test your applications before deploying them to a production environment.

- filename: docker-compose.yml

```yml
version: '3'

services:
  zookeeper:
    image: confluentinc/cp-zookeeper:6.2.1
    environment:
      ZOOKEEPER_CLIENT_PORT: 2181
      ZOOKEEPER_TICK_TIME: 2000

  kafka:
    image: confluentinc/cp-kafka:6.2.1
    depends_on:
      - zookeeper
    environment:
      KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
      KAFKA_ADVERTISED_LISTENERS: INTERNAL://kafka:9092,EXTERNAL://localhost:9094
      KAFKA_LISTENER_SECURITY_PROTOCOL_MAP: INTERNAL:PLAINTEXT,EXTERNAL:PLAINTEXT
      KAFKA_INTER_BROKER_LISTENER_NAME: INTERNAL
      KAFKA_LISTENERS: INTERNAL://:9092,EXTERNAL://:9094
      KAFKA_AUTO_CREATE_TOPICS_ENABLE: "true"
      KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR: 1
    ports:
      - "9094:9094"

```

