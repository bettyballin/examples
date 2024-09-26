from django.db import models
from cryptography.fernet import Fernet

ENCRYPTOR = Fernet.generate_key()

class MyModel(models.Model):
    key = models.CharField(max_length=255)
    secret = models.CharField(max_length=255)

    def save(self, *args, **kwargs):
        if not self.pk:
            f = Fernet(ENCRYPTOR)
            self.key = f.encrypt(self.key.encode())
            self.secret = f.encrypt(self.secret.encode())

        super().save(*args, **kwargs)