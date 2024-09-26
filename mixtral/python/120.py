from flask import current_app
from flask_wtf import FlaskForm
from wtforms import PasswordField
from wtforms.validators import DataRequired, ValidationError
from flask_bcrypt import bcrypt
from flask_login import current_user

class AccountSettingsForm(FlaskForm):
    password = PasswordField("Password:", validators=[DataRequired()])

    def validate_password(self, field):
        if not current_user.is_authenticated:
            raise ValidationError('User is not authenticated')

        # Assuming you're using Flask-Bcrypt to hash passwords
        if not bcrypt.checkpw(field.data.encode('utf-8'), current_user.password.encode('utf-8')):
            raise ValidationError('Password is invalid')