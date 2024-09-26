from flask import g
from wtforms import Form, TextField
from wtforms.validators import EqualTo

class AccountSettingsForm(Form):
    password_proof = TextField("Password:", [
        EqualTo(g.user.password, message='Passwords Invalid')
    ])