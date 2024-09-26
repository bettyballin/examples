This code is written in Swift, not Python. Here is the equivalent Python code:


import base64

class Data:
    def __init__(self, base64URL):
        base64 = base64URL.replace("-", "+").replace("_", "/")
        while len(base64) % 4 != 0:
            base64 += "="
        self.data = base64.b64decode(base64)

    @classmethod
    def from_base64URL(cls, base64):
        try:
            return cls(base64)
        except Exception:
            return None