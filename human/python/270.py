# Return a 50 character random string usable as a SECRET_KEY setting value.
from django.core.management.utils import get_random_secret_key

if __name__ == "__main__":
    SECRET_KEY = get_random_secret_key()
    print(SECRET_KEY)