import json
data = {'key': 'value'}
dataJSON = json.dumps(data, separators=(',', ':'))
print(dataJSON)