#!/bin/sh
mvn clean package && docker build -t org.example/compagenda .
docker rm -f compagenda || true && docker run -d -p 8080:8080 -p 4848:4848 --name compagenda org.example/compagenda 
