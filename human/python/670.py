import base64
import binascii

def is_base64(value):
    try:
        base64.b64decode(value['phone_number'])
    except binascii.Error:
        return False
    except KeyError:
        return False
    return True

# Test the function
data = {'phone_number': 'MTIzNDU2Nzg='}
print(is_base64(data))  # Should print: True

data = {'phone_number': 'Invalid base64'}
print(is_base64(data))  # Should print: False

data = {}
print(is_base64(data))  # Should print: False