from base64 import urlsafe_b64decode
from struct import unpack
from datetime import datetime, timedelta

def validate_fernet_token(c):
    bin_token = urlsafe_b64decode(c) 
    version, timestamp = unpack('>BQ', bin_token[:9])

    tok_age = datetime.now() - datetime.fromtimestamp(timestamp)
    max_age = timedelta(7) # 7 days

    if version != 0x80:
        print('Invalid token version!')

    if tok_age > max_age:
        print('Token expired!')
    elif tok_age < timedelta(0):
        print('Token timestamp in the future! Invalid token!')

# Example usage:
c = "your_fernet_token_here"
validate_fernet_token(c)