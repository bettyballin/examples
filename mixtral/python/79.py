from flask import current_user
from flask_security import core
from flask_sqlalchemy import db

class User(db.Model, core.UserMixin):
    # ...

    def get_id(self):
        return str(self.username)

    @property
    def is_authenticated(self):
        if isinstance(current_user._get_current_object(), User):
            return True
        return False

    @property
    def is_active(self):
        # Here you can add your own logic to check whether the user account is active
        return self.is_confirmed