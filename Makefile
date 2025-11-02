all: clean count

clean:
	echo "Cleaning ..."
	rm -f result.txt

count:
	./wordcount input.txt result.txt
