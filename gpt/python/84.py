
from twisted.cred.credentials import ICredentials
from zope.interface import implementer

@implementer(ICredentials)
class BcryptCredentials:
    def __init__(self, username, password):
        self.username = username
        self.password = password

