
from twisted.cred.checkers import ICredentialsChecker
from twisted.cred.error import UnauthorizedLogin
from twisted.internet.defer import fail, succeed
from zope.interface import implementer
import bcrypt

@implementer(ICredentialsChecker)
class BcryptCredentialsChecker:
    credentialInterfaces = (BcryptCredentials,)

    def __init__(self, userdb):
        """
        userdb is a dictionary-like object mapping usernames to bcrypt
