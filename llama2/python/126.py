from flask import current_app as app
from flask_admin import BaseModelView, expose
from flask_login import current_user

class UserModelView(BaseModelView):
    def __init__(self, *args, **kwargs):
        super(UserModelView, self).__init__(*args, **kwargs)
        if not current_user.has_role('superuser'):
            self.form_excluded_columns = ('created_at', 'updated_at', 'roles')

    def is_accessible(self):
        return current_user.has_role('superuser')

    def _handle_view(self, name, **kwargs):
        if not self.is_accessible():
            return app.login_manager.unauthorized()