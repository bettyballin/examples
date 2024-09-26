import time
import json

data = '''
{
    "delay": 3,
    "text_to_display": "Hello"
}
'''

config = json.loads(data)

time.sleep(config["delay"])
print(config["text_to_display"])