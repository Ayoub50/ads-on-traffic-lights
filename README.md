## Project Description
This project is built only for training purposes.
The initial idea was to use Apache Kafka and create something that can make the most of its potential.
So one possible real implementation is a system that, based on traffic light colors, displays different advertisements on billboards placed near the traffic light. This is to ensure that drivers at the traffic light can be entertained by advertising.

### Basic implemementation description

The project has been implemented using Java, relying on Spring Boot as a framework. The reason for choosing Spring Boot is its lightweight nature and the convenience of having an integrated Tomcat server. The real-time data streaming platform Apache Kafka is utilized, owing to its ability to separate clients into consumers and producers. As such, we will have producers responsible for the management and maintenance of various traffic sensors, such as traffic light colors or pedestrian reservation buttons. Moreover, they will also be tasked with managing electronic billboards that display different advertisements. On the other hand, consumers will be responsible for processing data from the various sensors to display relevant advertisements.

Multiple endpoints will be created to gather information about traffic, as well as different endpoints to cater to the needs of consumers, such as displaying an advertisement on a billboard.

Therefore, the idea is to make the application horizontally scalable with various replicable and enableable modules, based on the needs of consumers and producers.

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
