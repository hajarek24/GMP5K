all: clean count

clean:
    rm -f result.txt

count:
    ./wordcount input.txt result.txt
