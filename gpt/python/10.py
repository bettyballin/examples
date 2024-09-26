
from django.contrib.auth.models import User
from django.contrib.auth import authenticate

def custom_authenticate(username, password):
    try:
        # Check if the username exists
        User.objects.get(username=username)
    except User.DoesNotExist:
        # Username doesn't exist
        return 'invalid_username'
    
    # Username exists, now check the password using Django's authenticate
    user = authenticate(username=username, password=password)
    if user is not None:
        # Authentication successful
        return 'success'
    else:
        # Authentication failed because of an
