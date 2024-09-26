
from django.utils.crypto import constant_time_compare

def secure_int_compare(a, b):
    return constant_time_compare(str(a), str(b))

# Usage
token_from_user = 123456789
server_stored_token = 123456789

if secure_int_compare(token_from_user, server_stored_token):
    print("Tokens match!")
else:
    print("Tokens do not match!")

