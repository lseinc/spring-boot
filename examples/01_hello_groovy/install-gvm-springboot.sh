#!/bin/bash

JAVA=`which java`
GROOVY=`which groovy`

if [ ! -z "$JAVA" -o -z "$GROOVY" ] ;
then
  echo "Make sure java and groovy are in your path!" 
  exit 2;
fi

curl -s get.gvmtool.net | bash
gvm help
. ~/.gvm/bin/gvm-init.sh 
gvm ls springboot
gvm install springboot
spring --help

#spring jar app.jar app.groovy
#jar fvt app.jar
#java -jar app.jar
#spring jar app.jar app.groovy
#spring run app.groovy 

