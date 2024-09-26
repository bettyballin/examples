import json

key_data = {
  "primaryKeyId": 1794775293,
  "key": [
    {
      "keyData": {
        "typeUrl": "type.googleapis.com/google.crypto.tink.AesGcmKey",
        "value": "GiD5ojApaIM2MRpPhGf5sVMhxeA6NE5KjdzUxsJ0ChH/JA==",
        "keyMaterialType": "SYMMETRIC"
      },
      "status": "ENABLED",
      "keyId": 1794775293,
      "outputPrefixType": "TINK"
    }
  ]
}

print(json.dumps(key_data))