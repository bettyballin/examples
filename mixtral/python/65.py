#!/usr/bin/env python3

import secrets

def main():
    r = secrets.token_bytes(10)
    print(r)

if __name__ == "__main__":
    main()