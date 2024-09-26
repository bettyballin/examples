You've provided Go code, not C code. Here is the corrected Go code:

go
package main

import "os"
import "fmt"

/*
#cgo CFLAGS: -g -O3 -fno-stack-protector
#include "test.h"
*/
import "C"

func main() {
    if len(os.Args) >= 2 {
        argsWithoutProg := os.Args[1:]
        if argsWithoutProg[0] == "admin" {
            secret()
        }
    } else {
        regular()
    }
}

func regular() {
    fmt.Println("Go: BORING")
    C.hackme()
}

func secret() {
    fmt.Println("Go: SECRET FUNC")
}


And here is a simple C code (test.h and test.c) to make it work:

test.h:

#ifndef TEST_H
#define TEST_H

void hackme(void);

#endif  // TEST_H


test.c:

#include "test.h"

void hackme(void) {
    printf("C: HACKED\n");
}


Compile with:
bash
go build -o main .