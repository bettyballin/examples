#!/usr/bin/env python3

from binascii import unhexlify
from hashlib import sha256

def main():
    master_key = unhexlify("02F840A04114081690223B7069071A70D6DABB891763B638CC20C7EC3BD58E6C86")
    print(sha256(master_key).hexdigest())

if __name__ == "__main__":
    main()