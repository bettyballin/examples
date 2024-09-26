from twisted.internet import reactor, defer
from twisted.spread.pb import PBClientFactory
from zope.interface import implements
from twisted.cred.checkers import ICredentialsChecker
from twisted.cred.credentials import UnauthorizedLogin
from twisted.cred.portal import IRealm
from twisted.python.hashlib import scrypt
import hashlib

class MyCredentials(object):
    def __init__(self, username, password):
        self.username = username
        self.password = password

class MyChecker(object):
    implements(ICredentialsChecker)

    credentialInterfaces = (MyCredentials, )

    def __init__(self, stored_hash):
        self.stored_hash = stored_hash

    @defer.inlineCallbacks
    def requestAvatarId(self, credentials):
        if credentials.username == 'admin' and hashlib.scrypt(credentials.password.encode()).hexdigest() == self.stored_hash:
            defer.returnValue('my_avatar_id')
        else:
            raise UnauthorizedLogin()

class MyRealm(object):
    implements(IRealm)

    def requestAvatar(self, avatarId, mind, *interfaces):
        return ('my_avatar', None, lambda: None)

# Usage example:
stored_hash = hashlib.scrypt('mypassword'.encode()).hexdigest()

factory = PBClientFactory()
checker = MyChecker(stored_hash)
realm = MyRealm()
portal = Portal(realm, [checker])

deferred = factory.login(
    MyCredentials(username='admin', password='mypassword'),
    perspectiveName='perspective'
)

reactor.connectTCP("localhost", 8000, factory)

@defer.inlineCallbacks
def connected(perspective):
    print("Connected to %s" % (perspective,))
    yield defer.returnValue(None) # Do something with the `perspective`

factory.deferred.addCallback(connected)

reactor.run()