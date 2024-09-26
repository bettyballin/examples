from Crypto.Cipher import AES
from Crypto.Util import Counter
import os

CTRkey="2b7e151628aed2a6abf7158809cf4f3c"
iv=os.urandom(16)
ctr=Counter.new(128, initial_value=int(iv.hex(), 16))
cipherCTR=AES.new(bytes.fromhex(CTRkey), AES.MODE_CTR, counter=ctr)