#!/bin/sh
#parser.sh grants 1976 2015
i=$2
while [ $i -le $3 ]
do
	echo "hadoop jar patentindexer.jar PatentsIndexer patents/$1/$i parsedpatents/$1/$i"
	hadoop jar patentindexer.jar PatentsIndexer patents/$1/$i parsedpatents/$1/$i
	i=$(($i+1))
done

