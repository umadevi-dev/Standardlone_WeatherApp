#!/bin/bash

latitude=$1
longitude=$2
java -jar ../lib/weather-app.jar $latitude $longitude
