# Ollcargo_Kafka_Producer_PoC
Pour utiliser ce projet locallement avec les paramètres par défauts, vous devez disposer de Kafka sur le port 9092 et au moins java 11.
Cette PoC est aussi disponible avec Docker, voici un guide pour l'utiliser :

1. récupérer le code source
2. ouvrir un terminal à la racine du projet
3. Entrez les commandes:

    mvn package -DskipTests

    docker-compose up -d --build
    (si vous avez déjà utiliser une fois auparavant, vous pouvez utiliser : docker-compose up)

Toute l'application (l'API, Postgresql, kafka et zookeeper) devrait être lancé dans des containers.

4. pour mettre en place un consumer sur le kafka (dans le topic order) :

    docker run --network app-tier bitnami/kafka kafka-console-consumer.sh --bootstrap-server kafka:9092 --topic order

5. Avec Postman (ou un autre outil permettant de faire des requêtes comme curl ...):
    -envoyer un GET sur localhost:8080/ vous devriez obtenir un message indiquant que ça fonctionne en réponse
    -envoyer quelques requêtes POST sur localhost:8080/order avec un body similaire à:
        {
            "id":2,
            "deliveryAmount":55,
            "clientAmount":41
        }
    -envoyer un GET sur localhost:8080/order, vous devriez obtenir une liste de tout les orders que vous avez ajouter à la bdd
    -envoyer un GET sur localhost:8080/order/{id} ou {id} est l'id d'un des orders que vous avez envoyé plus tot
    -envoyer un POST sur localhost:8080/order/{id}/kafka ou {id} est l'id d'un des orders que vous avez envoyé plus tot, vérifier ensuite dans votre consumer kafka, l'order devrait apparaitre dans la console.

6. La commande :
    docker-compose stop
   permet de stopper toute l'application proprement.
