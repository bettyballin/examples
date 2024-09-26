
import base64
import binascii
from Crypto.Cipher import AES
from Crypto.Util.Padding import unpad
try:
    from urllib.request import urlopen
except ImportError:
    from urllib2 import urlopen
from axolotl.kdf.hkdfv3 import HKDFv3
from axolotl.util.byteutil import ByteUtil

class Decrypter():

    def decrypt(self, url, base64_mediaKey):
        encimg = urlopen(url).read()
        mediaKey = base64.b64decode(base64_mediaKey)
        cryptKeys  = b'576861747341707020496d616765
