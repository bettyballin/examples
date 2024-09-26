from flask import current_user
from flask_sqlalchemy import SQLAlchemy
from flask_admin.contrib.sqla import ModelView
from flask_admin.contrib.sqla.forms import ModelForm
from wtforms import fields

db = SQLAlchemy()

class MyModel(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    field1 = db.Column(db.String(100))
    field2 = db.Column(db.String(100))

class CustomCreateForm(ModelForm):
    class Meta:
        model = MyModel

    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)
        if current_user.has_role('admin'):
            self.field1 = fields.StringField('Field 1')
            self.field2 = fields.StringField('Field 2')

class CustomEditForm(ModelForm):
    class Meta:
        model = MyModel

    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)
        if current_user.has_role('admin'):
            self.field1 = fields.StringField('Field 1')
            self.field2 = fields.StringField('Field 2')

class MyModelView(ModelView):
    def is_accessible(self):
        if current_user.has_role('admin'):
            self._create_form = CustomCreateForm
            self._edit_form = CustomEditForm
        return super().is_accessible()