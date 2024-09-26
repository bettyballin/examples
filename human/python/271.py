# generate an even longer random string usable as a SECRET_KEY setting
from django.utils.crypto import get_random_string
chars = 'abcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*(-_=+)'
SECRET_KEY = get_random_string(100, chars)
print(SECRET_KEY)