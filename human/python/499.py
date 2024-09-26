import hmac
import hashlib

mac_key = b'mac_key'  # replace with your mac key
iv = b'iv'  # replace with your iv
file = b'file'  # replace with your file
mac = b'mac'  # replace with your mac

hmac_sha256 = hmac.new(mac_key, digestmod=hashlib.sha256)

iv_file = iv + file

mac_calc = hmac_sha256.update(iv_file).digest()

mac_calc10 = mac_calc[:10]

verified = mac_calc10 == mac[:10]