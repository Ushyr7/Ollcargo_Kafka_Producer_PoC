# Ollcargo_Kafka_Producer_PoC
Pour utiliser ce projet locallement avec les paramètres par défauts, vous devez disposer de Kafka sur le port 9092 et au moins java 11. Voici un petit guide d'utilisation minimaliste :

1. Demarrez Kafka et créez un topic "order"
2. mettre en place un consumer sur votre Kafka et sur ce topic pour vérifier si les commandes sont publiées
3. lancer l'API (mvn install puis mvn spring-boot:run)
4. A l'aide de Postman, tentez d'envoyer une requete post sur /order (un exemple est donné dans request.png)
5. Vérfiez votre consumer kafka (un exemple est donné dans KafkaConsumer.png)