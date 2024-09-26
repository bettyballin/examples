
from flask import render_template
from flask.views import MethodView
from flask_security import auth_required, roles_required, current_user

class RunningRoutesAdmin(MethodView):

    # Use a before_request method to apply decorators
    @classmethod
    def before_request(cls, *args, **kwargs):
        # Here you can add any pre-processing before each request
        pass

    # Define an additional classmethod to apply the decorator
    @classmethod
    def as_secure_view(cls, name, *class_args, **class_kwargs):
        view = cls.as_view(name, *class_args, **class_kwargs)
        view = auth_required('session', 'token')(view)
        return view

    def get(self):
        return render_template('admin.jinja2', pagename='Admin Home')

