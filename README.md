# Creation of Kafka Publisher/Producer using Spring Boot

# Prerequisites(Avoid below if using docker compose)

* Install Kafka from official page -https://kafka.apache.org/downloads
* Instal Confluent Kafka from official page -https://www.confluent.io/installation/
* Install Offset Explorer

# Steps to setup

### Kafka Commands
* Start Zookeeper Server
~~~
sh bin/zookeeper-server-start.sh config/zookeeper.properties
~~~
* Start Kafka Server / Broker
~~~
sh bin/kafka-server-start.sh config/server.properties
~~~

* Or avoid above two steps and start both Zookeeper and Kafka Server in one command
~~~
docker compose up
~~~

* Launch the spring boot application
* Use the endpoints and call them in any og the API testing tools like Postman, Insomnia, Bruno etc.
