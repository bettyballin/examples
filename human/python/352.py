from django.contrib.auth.models import User, AbstractBaseUser
from django.contrib.auth.hashers import make_password, check_password

class MyUser(AbstractBaseUser):
    def set_password(self, raw_password):
        self.password = make_password(self.username + raw_password)
        self._password = raw_password

    def check_password(self, raw_password):
        def setter(raw_password):
            self.set_password(raw_password)
            self._password = None
            self.save(update_fields=['password'])
        return check_password(self.username + raw_password, self.password) or setter(raw_password)

    def save(self, *args, **kwargs):
        super().save(*args, **kwargs)