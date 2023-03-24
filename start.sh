#!/bin/bash

java.exe -jar ./target/Sample-1.jar
# mvn org.codehaus.mojo:exec-maven-plugin:1.5.0:java -Dexec.mainClass="com.example.Main" | grep -Ev '(^\[|Download\w+:)'
#java -cp target/Sample-1.jar ru.dilvish13.Main

mvn archetype:generate -DgroupId=ru.dilvish13 -DartifactId=sample -Dversion=1.0