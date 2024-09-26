from flask import Flask, render_template
from flask_security import auth_required
from flask_classy import FlaskView

app = Flask(__name__)

class RunningRouteAdmin(FlaskView):
    decorators = [auth_required]

    def index(self):
        return render_template('admin.jinja2', pagename='Admin Home')

RunningRouteAdmin().register(app, route_base="/admin/")