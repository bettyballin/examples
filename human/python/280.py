import email.utils
from django.utils.encoding import force_text
from six import string_types

def sanitize_address(addr, encoding='utf-8'):
    if isinstance(addr, string_types):
        addr = email.utils.parseaddr(force_text(addr))
    nm, addr = addr
    return nm, addr