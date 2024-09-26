from flask_wtf import FlaskForm
from wtforms import StringField
from wtforms.validators import DataRequired, Length, Regexp

class ProjectName(FlaskForm):
    name = StringField('Project Name', validators=[DataRequired(), 
                       Length(min=1), 
                       Regexp("^[a-zA-Z0-9_]+$")])