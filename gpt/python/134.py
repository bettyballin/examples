
from flask_security import SQLAlchemyUserDatastore

class CustomUserDatastore(SQLAlchemyUserDatastore):
    def find_user(self, **kwargs):
        # Override to search by 'username' instead of 'email'
        if 'email' in kwargs:
            kwargs['username'] = kwargs.pop('email')
        return super(CustomUserDatastore, self).find_user(**kwargs)

# Then, when you
