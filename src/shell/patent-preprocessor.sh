#!/bin/bash
#. ./patent-preprocessor.sh /scratch/wshalaby/patents/raw/grants patents/grants
#. ./patent-preprocessor.sh /scratch/wshalaby/patents/raw/applications patents/applications
FILES="$1"
cd $FILES/
for f in $FILES/*.zip;
do
	echo "Processing $f...";
	#pat=$(echo $f | grep -o "..." | head -1)
	pat=$(echo $f | grep -o "/pft")
	year=$(echo $f | grep -o -P "[0-9]+" | head -1)
	twodigit=$(echo $year | grep -o -P ".." | head -1)
	ff=$(echo $f|sed -e 's/.zip//g')
	#unzip -o $f
	jar -xf $f
	if [ "$pat" = "/pft" ] 
	then
		ext=".txt"
	else
		ext=".xml"
	fi
	#for 2001 grants cat $ff$ext | tr '\r\n' ' ' | perl -pe 's|<!DOCTYPE.*?]>  |\n<!DOCTYPE math PUBLIC \"-//W3C//DTD MathML 3.0//EN\" \"dtds/mathml2.dtd\">|g' | tail -n +1  > $ff"lines"$ext
	#for 2004 grants cat $ff$ext | tr '\r\n' ' ' | sed -e 's/<?xml version="1.0" encoding="UTF-8"?>  /\n/g' | perl -pe 's|<!DOCTYPE math PUBLIC \"-//W3C//DTD MathML 3.0//EN\" \"dtds/mathml2.dtd\">|g' | tail -n +2  > $ff"lines"$ext
	#for 2004 apps cat $ff$ext | tr '\r\n' ' ' | sed -e 's/<?xml version="1.0" encoding="UTF-8"?> /\n/g' | perl -pe 's|<!DOCTYPE math PUBLIC \"-//W3C//DTD MathML 3.0//EN\" \"dtds/mathml2.dtd\">|g' | tail -n +2  > $ff"lines"$ext
	#for 2002,2003 applications confirmed cat $ff$ext | tr '\r\n' ' ' | sed -e 's/<?xml version="1.0" encoding="UTF-8"?>/\n/g' | perl -pe 's|<!DOCTYPE.*?]>  ||g' | tail -n +2  > $ff"lines"$ext
	cat $ff$ext | tr '\r\n' ' ' | sed -e 's/<?xml version="1.0" encoding="UTF-8"?>  /\n/g' | perl -pe 's|<!DOCTYPE.*?]>  ||g' | tail -n +2  > $ff"lines"$ext
	if [ "$twodigit" = "19" ] || [ "$twodigit" = "20" ]
	then
		year="$(echo $year | grep -o -P '....' | head -1)"
	else
		year="$(echo '20'$year | grep -o -P '....' | head -1)"
	fi
	hdfs dfs -mkdir $2/$year/
	hdfs dfs -put $ff"lines"$ext $2/$year/
	rm $ff$ext
	rm $ff"lines"$ext
done; 
cd -
