from enum import Enum

class UserRole(Enum):
    Admin = 1
    User = 2

class User:
    def __init__(self, role):
        self.role = role

class CustomUserManager:
    def get_user(self, iserver, username=None, password=None, certificate=None):
        if username == "admin":
            if password == 'secret_admin_pw':
                return User(role=UserRole.Admin)
        elif username == "user":
            if password == 'secret_pw':
                return User(role=UserRole.User)
        return None