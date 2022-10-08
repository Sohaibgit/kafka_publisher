# kafka Publisher

**Start Zookeeper Server:**\
D:/kafka/bin/windows -> zookeeper-server-start.bat D:/kafka/config/zookeeper.properties


**Start Kafka Server:**\
Enable listener in server.properties as below\
listeners=PLAINTEXT://localhost:9092\
D:/kafka/bin/windows -> kafka-server-start.bat D:/kafka/config/server.properties

**Create Topic:**\
kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic spring-cloud-topic

**To List Topics:**\
kafka-topics.bat --bootstrap-server localhost:9092 --list

**Now check message published in consumer console:**\
kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic mytopic1
