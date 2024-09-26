from flask import g
from flask_admin import Admin
from flask_admin.contrib.sqla import ModelView
from flask_admin import BaseForm
from wtforms import SelectField
from yourapp import app, db
from yourapp.models import User, Role

# Initialize admin
admin = Admin(app, name='Your App', template_folder='templates/admin')

# Custom form classes
class RoleSelectField(SelectField):
    def __init__(self, **kwargs):
        super().__init__('Role', choices=[(r.id, r.name) for r in Role.query.all()], **kwargs)

class SuperUserEditForm(BaseForm):
    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)
        self.role = RoleSelectField()

class ClientEditForm(SuperUserEditForm):
    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)
        del self.role

# In your UserModelView class
class UserModelView(ModelView):
    form = SuperUserEditForm

    def is_accessible(self):
        return hasattr(g, 'current_user') and g.current_user.has_role('superuser')

    def get_edit_form(self):
        if hasattr(g, 'current_user') and g.current_user.has_role('client'):
            return ClientEditForm
        return SuperUserEditForm

# In your app's initialization
admin.add_view(UserModelView(model=User, session=db.session))