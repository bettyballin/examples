
from flask_security import current_user
from flask_admin.contrib.sqla import ModelView

class MyModelView(ModelView):

    def scaffold_form(self):
        # Start with the standard form as provided by Flask-Admin
        form_class = super(MyModelView, self).scaffold_form()
        
        if current_user.is_authenticated:
            # Check the user's role and adjust the form accordingly
            if current_user.has_role('admin'):
                # Admin sees all fields
                pass
            elif current_user.has_role('manager'):
                # Manager-level adjustments
                del form_class.some_sensitive_field
            else:
                # For other roles, remove other fields
                del form_class.some_sensitive_field
                del form_class.another_field
        else:
            # If nobody is authenticated, show a minimal form
            del form_class.some_sensitive_field
            del form_class.another_field
            del form_class.additional_field

        return form_class

