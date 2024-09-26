from Crypto.PublicKey import RSA
from Crypto.Cipher import PKCS1_OAEP

# Load private key
private_key = """-----BEGIN RSA PRIVATE KEY-----
MIICXAIBAAKBgQDL/TzI4yHmlcC8qP3xWNieujmXR7CnEaZJrDH1Hyr/tGNa0aEE
jDIz+RlMntBbhOuiQMkMtCSB5X28h7HetiD4XkWTXmlIiKZQLZ074cO5mxF+HhF7
WIG30VONpX+Q4t/beqtaqbzyeIWvDdcCjUwOSQLrUKU5PX9LFzX+FnN1UwIDAQAB
AoGASRVZib+Wjb5pZy5EjQt/0J53s7ODnte78/k1jNS12xcN4aPpRG/WLLi6T7E2
hROCOIdtgJep3MAT5E/ZciledflaDwwmLo6+NsrhMppsNhpIHsvxWxmwxnH+bC2H
lpyeUmxku4xzqwYW4kuF3iaR45K2eUpXQyWTE9+pgvepgoECQQDT6Waiavstvs4W
btW2P4J+7O//NmTcvnyLTnhFTXklxTxnSun54HYOce8+TttsXWESTbzf91saN5SW
0vPyKK25AkEA9m3gbwFppiA65464jnDCP1AnrR15n3tbsLpaadYdRm07b+4BB0R2
M820cgber14JiGndOfv1uPl1Ooy0IH4hawJBAJKRC/uqIrAxGDlLz2SN6KQBHL1X
0csbtOhlDaphOzl0gaKvncTGCuFSzDY8NGdu7oTKX6hIXSp05sCqhy8mE4ECQE49
xKx5/llIkmtC3UYcdxAzGuXUHfGM8SfDg0FnQhRCSkTXhGwSSJVaEpjBpaJ4cP5m
3l6yqOn6CkZ0thw679ECQCWNC5hVEtsAb0TcjGdTpw+xTFusiZciNyHTQ64Zq2cc
ehQrxTRDIEBA4wIgUwrTwdVXk10OtpcVZvLIVjqdC84=
-----END RSA PRIVATE KEY-----"""

# Load public key
public_key = """-----BEGIN PUBLIC KEY-----
MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDL/TzI4yHmlcC8qP3xWNieujmX
R7CnEaZJrDH1Hyr/tGNa0aEEjDIz+RlMntBbhOuiQMkMtCSB5X28h7HetiD4XkWT
XmlIiKZQLZ074cO5mxF+HhF7WIG30VONpX+Q4t/beqtaqbzyeIWvDdcCjUwOSQLr
UKU5PX9LFzX+FnN1UwIDAQAB
-----END PUBLIC KEY-----"""

# Load encoded data
encoded_data = b'\x843\x9aJ\xe6\x91p\xd2\x9c\xd0r{37\xa2G\x13Q\xc7~\xbd5\xce\x9f\xd4\x16\xda\x11\x02.\xb7\xf1\xf3Q\x8c|\xb0R2B\x1b)e\xeaD\x8e\x11\x1b\xb0J:\xbal\xac\x86\xdcb}_\x16IX\xccd\x0c\xb5E?Im<\x04ORT\xc9\xc6K|;\xf3\xbcK\xfd\x89\x96ZF(\x0b\x82v\x19`\xc3\xa1N\x934*\x9c\xfcT\xf4i\x02g\x1fl\xec\xc1\x19z\x9f7\xa6}\xe2\xe3}\xaa|\x1e\x13z\xd9$\xea'

# Load private key
private_key_loaded = RSA.importKey(private_key)

# Create a cipher object
cipher = PKCS1_OAEP.new(private_key_loaded)

# Decrypt the data
decrypted_data = cipher.decrypt(encoded_data)

# Print the decrypted data
print(decrypted_data.decode('utf-8'))