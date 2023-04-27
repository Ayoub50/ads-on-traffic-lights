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
