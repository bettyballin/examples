
from flask_admin.contrib.sqla import ModelView
from flask_security import current_user

class UserModelView(ModelView):

    def scaffold_form(self):
        form_class = super(UserModelView, self).scaffold_form()
        if not current_user.has_role('superuser'):
            # Exclude the 'roles' field for non-superuser
            del form_class.roles
        return form_class

    def is_accessible(self):
        # You should also override this method to ensure that only
        # authenticated users with the appropriate role can access this view.
        return current_user.is_authenticated and current_user.has_role('superuser')

