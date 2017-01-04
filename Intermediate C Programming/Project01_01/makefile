CC=gcc
CFLAGS=-Wall -std=c99
DEPS=functions.h
OBJS=functions.o main.o

%.0: %.c $(DEPS)
	$(CC) -c -o $@ $< $(CFLAGS)
	
project01_01: $(OBJS)
	$(CC) -o $@ $^
	
.PHONY: clean

clean:
	rm -f *.o *~ project01_01