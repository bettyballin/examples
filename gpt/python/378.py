
import binascii
import base64
from Crypto.Cipher import DES3
from Crypto.Util.Padding import pad
import json

iv = base64.b64decode('04njBuE3/dc=')
key = base64.b64decode('DpzDLcvVCHdVoRqE/NuIHs0QJ0xFdH2p')
data = {
    'CartaoNumero': '0000000000000000',
    'CartaoMesAno': '00/0000',
    'CartaoSeg': '000',
    '
