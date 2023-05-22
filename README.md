## Hoteladvisors-test-task

Тестовое задание для компании Hoteladvisors, web проект с применение framework - zkoss mvc, база данных mysql, orm
hibernate, docker compose, сервер приложений WildFly.

## Полезные команды сборки

run jetty (using gretty)

```
./gradlew appRun
```

run tomcat (using gretty)

```
./gradlew tomcatRun
```

run jetty (with jetty-runner - faster startup)

```
./gradlew startJettyRunner
```

run wildfly

```
./gradlew startWildflyRunner
```

http://localhost:8080/hoteladvisors

run tests

```
./gradlew test
```

build war

```
./gradlew war
```

build ear

```
./gradlew ear
```

## Mysql можно запустить в Docker контейнере

Для этого в терминале запустите данную команду

docker run -d -p 3306:3306 --name mysql-docker-container -e MYSQL_ROOT_PASSWORD=1234 -e MYSQL_DATABASE=hoteladvisors -e
MYSQL_USER=ha_user -e MYSQL_PASSWORD=1234 mysql/mysql-server:latest

## Wildfly можно запустить в Docker контейнере

Для этого в терминале запустите данную команду

docker run -d -p 8081:8080 -p 9993:9990 --name wildfly-docker-container -it jboss/wildfly
/opt/jboss/wildfly/bin/standalone.sh -b 0.0.0.0 -bmanagement 0.0.0.0

## Лицензия

* Demo Code - [Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0)
