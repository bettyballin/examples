from flask import redirect, url_for, request
from flask_admin import Admin
from flask_admin.contrib.sqla import ModelView
from flask_security import current_user

class UserViewForAdmin(ModelView):

    def is_accessible(self):
        return current_user.has_role("admin")

    def inaccessible_callback(self, name, **kwargs):
        return redirect(url_for("security.login", next=request.url))

admin = Admin(name="Flask-Admin Example")

admin.add_view(UserView(User, db.session, name="Profile"))
admin.add_view(UserViewForAdmin(User, db.session, name="UserList", endpoint="users"))