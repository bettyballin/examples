from django import forms
from django.contrib.auth.models import User

class UsernameForm(forms.Form):
    username = forms.CharField(max_length=255)

    def clean_username(self):
        username = self.cleaned_data['username']
        try:
            User.objects.get(username=username)
        except User.DoesNotExist:
            raise forms.ValidationError("The username you have entered does not exist.")
        return username