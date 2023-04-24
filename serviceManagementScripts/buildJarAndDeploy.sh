
### Create the jar to be deployed
mvn -f /media/troller/maxone/DevelopmentPractice/ProjectMocks/Java/JavaSpringBoot/Kafka/adsNearTrafficLights/pom.xml clean install

### Move the jar to its correct folder 
cp ../target/ads-on-traffic-lights.jar /opt/JavaProjects/AdsOnTrafficLights/ads-on-traffic-lights.jar

### stop service
systemctl stop ads-on-traffic-lights.service

### start service 
systemctl start ads-on-traffic-lights.service



