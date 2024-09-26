from flask import Flask, g
from wtforms import Form, TextField
from wtforms.validators import ValidationError

app = Flask(__name__)
app.config["SECRET_KEY"] = "secret_key_here"

class AccountSettingsForm(Form):
    password_proof = TextField("Password:", [
        lambda form, field: field.validate(form, field) or (field.data == g.user.password or raise ValidationError('Passwords Invalid'))
    ])

if __name__ == "__main__":
    app.run()