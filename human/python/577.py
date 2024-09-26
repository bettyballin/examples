import json

testing = '{"ip": "192.168.1.1"}'
settings = json.loads(testing)
print(settings["ip"])