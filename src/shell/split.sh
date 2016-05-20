#!/bin/sh
#split.sh grants 1976 2015
#split.sh applications 2001 2015
hdfs dfs -mkdir patents/$1
i=$2
while [ $i -le $3 ]
do
	hdfs dfs -mkdir patents/$1/$i
	i=$(($i+1))
done
