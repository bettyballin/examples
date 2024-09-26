Here is the code with the necessary modifications to make it executable:


#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <time.h>

// X -- select operation:
//   0 -- +
//   1 -- ^
#ifndef X
#define X   0
#endif

// Y -- select equation
//   0  -- original code:
//   1  -- original code refactored to use macros
//   2  -- recoding direct from above comment:
//   3  -- changed final term from "1" to "B(0)" per wiki page:
#ifndef Y
#define Y       3
#endif

// W -- number of bits to wrap/fail on
#ifndef W
#define W           28
#endif

#if X == 0
#define x +
#else
#define x ^
#endif
#undef X

#define B(_s) \
    (lfsr >> _s)

#define X(_s) \
    x B(_s)

#if (W < 32) || BIG
#define WMSK        ((1L << W) - 1)
#else
#define WMSK        ~0u
#endif

#if BIG
typedef uint64_t PER;
#define FMT16       "%16.16llX"
#define FMT10       "%-20llu"
#else
typedef uint32_t PER;
#define FMT16       "%8.8X"
#define FMT10       "%-10u"
#endif

int opt_R;
int opt_C;

char *
strbuf(void)
{
    static int idx = 0;
    static char buf[16][1024];
    char *bp = buf[idx];

    if (++idx >= 16)
        idx = 0;

    *bp = 0;

    return bp;
}

const char *
xprt(PER val,int what)
{
    char *buf = strbuf();
    char *bp = buf;

    switch (what) {
    case 1:
        bp += sprintf(bp,FMT16,val);
        break;
    case 2:
        bp += sprintf(bp,FMT10,val);
        break;
    default:
        bp += sprintf(bp,FMT16,val);
        bp += sprintf(bp,"/");
        bp += sprintf(bp,FMT10,val);
        break;
    }

    return buf;
}

struct period {
    PER period;
    PER count;
    struct period *next;
};
struct period *perlist;

void
store(PER period)
{
    struct period *prev = NULL;
    struct period *cur = perlist;

    for (;  cur != NULL;  cur = cur->next) {
        if (cur->period == period)
            break;
        prev = cur;
    }

    do {
        if (cur != NULL)
            break;

        cur = calloc(1,sizeof(*cur));
        cur->period = period;

        if (prev != NULL)
            prev->next = cur;
        else
            perlist = cur;
    } while (0);

    cur->count += 1;
}

PER
lfsr_fib(uint32_t start_state)
{
    uint32_t bit;
    uint32_t lfsr = start_state;
    PER period = 0;
    int bad = 0;

    printf("lfsr=%s",xprt(lfsr,1));

    do {

        /*
           polynomial: x^24 + x^23 + x^22 + x^20 + x^19 + x^18 + x^17 + x^16 +
            x^15 + x^13 + x^12 + x^8 + x^7 + x^6 + 1 */

        // NOTE: will optimize down to single/inlined case:
        switch (Y) {
        case 0:  // original code:
            bit = ((lfsr >> 7) ^ (lfsr >> 8) ^ (lfsr >> 9) ^ (lfsr >> 11) ^
                (lfsr >> 12) ^ (lfsr >> 13) ^ (lfsr >> 14) ^ (lfsr >> 15) ^
                (lfsr >> 16) ^ (lfsr >> 18) ^ (lfsr >> 19) ^ (lfsr >> 23) ^
                (lfsr >> 24) ^ (lfsr >> 25)) & 1u;
        break;

        case 1:  // original code refactored to use macros
            bit = 0 X(25) X(24) X(23) X(19) X(18) X(16) X(15) X(14) X(13) X(12)
                X(11) X(9) X(8) X(7);
            break;

        case 2:  // recoding direct from above comment:
            bit = B(24) x B(23) x B(22) x B(20) x B(19) x B(18) x B(17) x
                B(16) x B(15) x B(13) x B(12) x B(8) x B(7) x B(6) x 1;
            break;

        case 3:  // changed final term from "1" to "B(0)" per wiki page:
            bit = 0 X(24) X(23) X(22) X(20) X(19) X(18) X(17) X(16)
                X(15) X(13) X(12) X(8) X(7) X(6) X(0);
            break;
        }

        // NOTE: not necessary, but ...
        bit &= 1u;

        lfsr = (lfsr >> 1) | (bit << 31);

        ++period;

        bad = (period & WMSK) == 0;
        if (bad)
            break;
    } while (lfsr != start_state);

    if (bad) {
        printf(" FAIL\n");
        period = 0;
    }
    else
        printf(" period=%s\n",xprt(period,2));

    store(period);

    return period;
}

void
title(const char *str)
{

    printf("\n");
    printf("%s:\n",str);
}

int
main(int argc,char **argv)
{

    --argc;
    ++argv;

    for (;  argc > 0;  --argc, ++argv) {
        char *cp = *argv;
        if (*cp != '-')
            break;

        cp += 2;
        switch (cp[-1]) {
        case 'C':
            opt_C = (*cp != 0) ? atoi(cp) : 100;
            break;

        case 'R':
            opt_R = (*cp != 0) ? atoi(cp) : 1;
            break;
        }
    }

    setbuf(stdout,NULL);
    printf("WMSK=%s\n",xprt(WMSK,3));
    printf("Y=%d\n",Y);

    title("static");
    lfsr_fib(1u << 31 | 1);
    lfsr_fib(1u << 31 | 0);
    lfsr_fib(0u << 31 | 0);
    lfsr_fib(0u << 31 | 1);
    lfsr_fib(0x1234);

    title("bitslide");
    for (uint32_t rhs = 0u;  rhs != 0x02;  rhs += 1) {
        for (uint32_t lhs = 1u;  lhs != 0;  lhs <<= 1)
            lfsr_fib(lhs | rhs);
    }

    if (opt_R) {
        if (opt_C <= 0)
            opt_C = 10;

        srand(time(NULL) + opt_R);

        title("random");
        for (int tryno = 1;  tryno <= opt_C;  ++tryno) {
            uint32_t rval = rand();
            lfsr_fib(rval);
        }
    }

    // show final results
    title("counts");
    for (struct period *cur = perlist;  cur != NULL;  cur = cur->next)
        printf("period=%s count=%s\n",
            xprt(cur->period,2),xprt(cur->count,2));

    return 0;
}