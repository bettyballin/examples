cpp
#include <stdio.h>
#include <string.h>
#include <openssl/bn.h>
#include <openssl/rsa.h>
#include <openssl/bio.h>
#include <openssl/evp.h>

int main(int argc, char* argv[])
{
    int ret = -1;

    char nz[] = "sqprMX0n4y1gmmgpTt6pHb870k5U0MIuXixidD+S8foQf5Bb"
             "FS44kth2uWDKzXOXqiONxIPHPb+84XdxrRi2O7bvLysztgrF"
             "eU8oNDMeuIwJOKVQzKoJ1vGqjBKiA9w48oQKxvO+Ck3GmObW"
             "67LFNcrt50sEco2/OMmrpiH3W8hRx55TcR1flCJduU0/6jA7"
             "Yct9ZfhOw5wBq6o5IwiT8Mi1R6LVq9sTzSNAWHC/bFcEONkt"
             "z6NgUKbFKtt+mTfFGToiwPB1L4TecGyTIweH84nl8jVAngcM"
             "vvFP415Eg1kd9PJbRqrIESM5AU1YcsapWV3bsqEGVS2y+r5N"
             "4yzXPCYRCRyFWJSnNVlax+gtDFTNz3m9UT8m2E7elGe5hPhR"
             "6nN3votzBNvTeQ4Lwc5JDIvnWUg7aOdVIXnHQbBqEQke79BX"
             "xIv8tzVPczGkFqFExkmPPQQv8zJvBKkIYc+BFJtkylBiZfQX"
             "0590NS3L1y31VSeXn8Ncx2/ceJfUXsMWJ3sQ+dk51MKBJ2LL"
             "oyJq8IgloBLnXWvlYZ+tkzRVTExFR277V3Jr17DeTOMQGEg5"
             "HqRkbDDVGPTl2RvC2S2BTe7+r9xNzyAZMieVjZLZgb6icE6u"
             "SJFcu4qqJ1khQUjW7taymqW8Ao3oEiCUJKvRpZcJPMN+JtMn"
             "ji+2we17ytk=";

    char ez[] = "AQAB";

    BIO* nn = NULL, *ee = NULL;
    BIO* b1 = NULL, *b2 = NULL;
    RSA* rsa = NULL;

    nn = BIO_new_mem_buf(nz, strlen(nz));
    if(!nn) { ret = 1; goto done; }

    ee = BIO_new_mem_buf(ez, strlen(ez));
    if(!ee) { ret = 2; goto done; }

    b1 = BIO_new(BIO_f_base64());
    if(!b1) { ret = 3; goto done; }

    b2 = BIO_new(BIO_f_base64());
    if(!b2) { ret = 4; goto done; }

    BIO_set_flags(b1, BIO_FLAGS_BASE64_NO_NL);
    BIO_set_flags(b2, BIO_FLAGS_BASE64_NO_NL);

    nn = BIO_push(b1, nn);
    if(!nn) { ret = 5; goto done; }

    ee = BIO_push(b2, ee);
    if(!ee) { ret = 6; goto done; }

    rsa = RSA_new();
    if(rsa == NULL) { ret = 7; goto done; }

    unsigned char buff[4096];
    const int bsize = sizeof(buff);
    int rr = 0, rd = 0;

    rd = 0;
    do {
        rr = BIO_read(nn, buff + rd, bsize - rd);
        if(rr < 0) { ret = 8; goto done; } 

        rd += rr;
    } while (rr > 0 || BIO_should_retry(nn));

    if(rd == 0) { ret = 9; goto done; }

    rsa->n = BN_bin2bn(buff, rd, NULL);
    if(rsa->n == NULL) { ret = 10; goto done; }

    rd = 0;
    do {
        rr = BIO_read(ee, buff + rd, bsize - rd);
        if(rr < 0) { ret = 11; goto done; } 

        rd += rr;
    } while (rr > 0 || BIO_should_retry(ee));

    if(rd == 0) { ret = 12; goto done; }

    rsa->e = BN_bin2bn(buff, rd, NULL);
    if(rsa->e == NULL) { ret = 13; goto done; }

    RSA_print_fp(stdout, rsa, 0);

    ret = 0;

done:

    if(ret != 0)
        fprintf(stderr, "Failed to parse and validate RSA key\n");

    if(rsa)
       RSA_free(rsa), rsa = NULL;

    if(nn)
        BIO_free_all(nn), nn = NULL;

    if(ee)
        BIO_free_all(ee), ee = NULL;

    return ret;
}