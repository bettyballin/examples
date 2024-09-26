import binascii

print(binascii.unhexlify('{:0{}x}'.format(19, int(1024/4))))