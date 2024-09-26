from flask import flash
from yourapp.security import _security
from yourapp.utils import generate_confirmation_link, get_message

confirmation_link, token = None, None

# assuming user is an object with an email attribute
if _security.confirmable:
    confirmation_link, token = generate_confirmation_link(user)
    flash(*get_message('CONFIRM_REGISTRATION', email=user.email))