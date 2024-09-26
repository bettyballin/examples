from flask import Flask, MethodView
from flask_login import login_required
from functools import wraps

app = Flask(__name__)

def auth_required(f):
    @wraps(f)
    def decorated_function(*args, **kwargs):
        return f(*args, **kwargs)
    return decorated_function

class RunningRoutesAdmin(MethodView):
    decorators  = [auth_required]

    def get(self):
        return "Hello, World!"

def _apply_decorors(f):
    for decorator in RunningRoutesAdmin.decorators:
        f = decorator(f)
    return f

admin_view = _apply_decorors(RunningRoutesAdmin.as_view('admin'))
app.add_url_rule('/admin/', view_func=admin_view, methods=['GET'])

if __name__ == '__main__':
    app.run(debug=True)