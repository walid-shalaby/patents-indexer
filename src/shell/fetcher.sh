#!/bin/sh
#fetcher.sh parsedpatents/grants /users/wshalaby/cc/project/data/parsed/grants 2005 2009
i=$3
while [ $i -le $4 ]
do
	echo "hdfs dfs -text $1/$i/* > $2/$i.txt"
	hdfs dfs -text $1/$i/* > $2/$i.txt
	i=$(($i+1))
done

