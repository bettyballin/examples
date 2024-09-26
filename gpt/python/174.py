
from flask_wtf import FlaskForm
from wtforms import PasswordField, SubmitField
from wtforms.validators import DataRequired
from werkzeug.security import check_password_hash
from flask_login import current_user

class AccountSettingsForm(FlaskForm):
    password_proof = PasswordField('Password:', validators=[DataRequired()])
    submit = SubmitField
