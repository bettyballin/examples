import os

try:
    SECRET_KEY = os.environ['DJANGO_SECRET']
except KeyError:
    print("Error: DJANGO_SECRET environment variable is not set.")
    exit(1)