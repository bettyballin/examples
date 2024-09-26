#include <stdio.h>

#define MAX_SHIFT 32 // maximum amount to be shifted

// this may not be constant time.
// However, you can find different (more ugly) ways to achieve the same thing.
// 1 -> 0
// 0 -> 0xff...
#define MASK(cond) (-(cond)) 

// again, make sure everything here is constant time according to your threat model
// (0, x, y) -> y
// (i, x, y) -> x (i != 0)
#define SELECT(cond, A, B) ((MASK(!(cond)) & A) | (MASK(!!(cond)) & B))

int shift(int value, int shift){
    int result = value;
    for(int i = 0; i <= MAX_SHIFT; i++){
        result = SELECT(i ^ shift, result, value);
        // this may not be constant time. If it is not, implement it yourself ;)
        value <<= 1; 
    }
    return result;
}

int main() {
    printf("%d\n", shift(1, 3));
    return 0;
}