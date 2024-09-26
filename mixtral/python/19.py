from twisted.conch import checkers
from twisted.python import defer
from twisted.python import error
import bcrypt

class BcryptPortal(checkers.InMemoryUsernamePasswordDatabaseDontUse):
    def __init__(self, users_and_passwords=None):
        self._users = {}

        if users_and_passwords:
            for user, password in users_and_passwords:
                hashed_pw = bcrypt.hashpw(
                    bytes(password, 'utf-8'),
                    bcrypt.gensalt()
                )

                self._users[user] = {
                    'hashed_pass': hashed_pw
                    # Add any other user data here
                }

    def requestAvatarId(self, credentials):
        username = credentials.username

        if self._users and (
            not isinstance(credentials, checkers.UsernamePassword) or
            username not in self._users
        ):

            return defer.fail(
                error.UnauthorizedLogin('No such user: %s' %
                    credentials.username))

        password = bytes(credentials.password, 'utf-8')

        if bcrypt.checkpw(
           password,
           self._users[username]['hashed_pass']
         ):
            return defer.succeed({
                'user': username
             })

        else:

            return defer.fail(
                 error.UnauthorizedLogin('Bad credentials')
              )