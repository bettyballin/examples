from tink import JsonKeysetReader
from tink import cleartext_keyset_handle
from tink import aead

serialized_keyset = '''
{
  "primaryKeyId": 1794775293,
  "key": [
    {
      "keyData": {
        "typeUrl": "type.googleapis.com/google.crypto.tink.AesGcmKey",
        "value": "GiAAAQIDBAUGBwgJCgsMDQ4PEBESExQVFhcYGRobHB0eHw==",
        "keyMaterialType": "SYMMETRIC"
      },
      "status": "ENABLED",
      "keyId": 1794775293,
      "outputPrefixType": "TINK"
    }
  ]
}   
'''
reader = JsonKeysetReader(serialized_keyset)
keyset_handle = cleartext_keyset_handle.read(reader)

plaintext = b'The quick brown fox jumps over the lazy dog'
aead_primitive = keyset_handle.primitive(aead.Aead)
tink_ciphertext = aead_primitive.encrypt(plaintext, b'')

print(tink_ciphertext)