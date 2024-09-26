from flask_wtf import FlaskForm as Form
from wtforms import PasswordField
from wtforms.validators import DataRequired, ValidationError
from flask_login import current_user
import bcrypt

class AccountSettingsForm(Form):
    password = PasswordField("Current Password:", validators=[DataRequired()])

    def validate_password(self, field):
        if not bcrypt.checkpw(field.data.encode('utf-8'), current_user.password_hash.encode('utf-8')):
            raise ValidationError('Invalid password')