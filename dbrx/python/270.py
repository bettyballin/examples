import json

def editjson(location, value):
    with open("./config.json", "r+") as handler:
        d = json.load(handler)
        d[location] = [value.decode()]
        handler.seek(0)
        json.dump(d, handler)
        handler.truncate()

with open("./config.json", "rb") as handler:
    info = json.load(handler)
    user = info["user"].encode()
    password = info["password"].encode()
    firstrun = info["firstrun"]