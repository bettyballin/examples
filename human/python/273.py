#!/usr/bin/env python3
import base64
from Crypto.Cipher import AES

MODE = AES.MODE_CFB
BLOCK_SIZE = 16
SEGMENT_SIZE = 128

def _pad_string(value):
    length = len(value)
    pad_size = BLOCK_SIZE - (length % BLOCK_SIZE)
    return value.ljust(length + pad_size, '\x00')

def encrypt(key, iv, plaintext):
    aes = AES.new(key.encode('utf-8'), MODE, iv.encode('utf-8'), segment_size=SEGMENT_SIZE)
    plaintext = _pad_string(plaintext)
    encrypted_text = aes.encrypt(plaintext.encode('utf-8'))
    return encrypted_text

key = 'TfvY7I358yospfWKcoviZizOShpm5hyH'
iv = 'mb13KcoviZizvYhp'
original_message = 'This is not encrypted'

encryptedpayload = base64.b64encode(encrypt(key, iv, original_message))

print('Going to encrypt and base64 "{}" result:\n{}\n'.format(original_message,encryptedpayload))