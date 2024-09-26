// test.c
#include <stdio.h>

void testFunction() {
    printf("Hello, World!\n");
}


go
// main.go
package main

/*
#cgo CFLAGS: -g -O3
#cgo LDFLAGS: -L. -ltest
#include "test.h"
*/
import "C"
import "unsafe"

func main() {
    cs := C.CString("Hello from C!")
    C.testFunction()
}


bash
# Makefile
test.o: test.c
    gcc -c -o test.o test.c

libtest.so: test.o
    gcc -shared -o libtest.so test.o

main: main.go libtest.so
    go build -o main main.go

run: main
    ./main

clean:
    rm -f test.o libtest.so main