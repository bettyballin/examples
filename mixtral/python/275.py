from django.db import models
from django import forms
from fernet_fields import EncryptedTextField

class MyModel(models.Model):
    key = EncryptedTextField()
    secret = EncryptedTextField()

class ApiForm(forms.ModelForm):

    class Meta:
        model = MyModel
        fields = ("key", "secret")