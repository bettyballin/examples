#!/usr/bin/env python3

try:
    from secrets import token_hex
except ImportError:
    from os import urandom
    def token_hex(nbytes=None):
        return urandom(nbytes).hex()

print(token_hex(16))