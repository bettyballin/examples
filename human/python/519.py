from Crypto.Util.Padding import pad
import json

dataJSON = '{"key": "value"}'  # example JSON data
dataPadded = pad(dataJSON.encode('utf-8'), 8)

print(dataPadded)