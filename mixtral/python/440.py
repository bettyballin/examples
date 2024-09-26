import dns
from dns import resolver

def is_connected():
    try:
        result = resolver.query('google.com', 'A')
        return True
    except Exception as e:
        print(e)
        return False

resolver.nameservers=['8.8.4.4']
print(is_connected())