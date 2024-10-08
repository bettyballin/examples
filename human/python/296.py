from flask_appbuilder.security.manager import AUTH_OID
from flask_appbuilder.security.sqla.manager import SecurityManager
from flask_oidc import OpenIDConnect
from flask_appbuilder.security.views import AuthOIDCView

class OIDCSecurityManager(SecurityManager):
    def __init__(self, appbuilder):
        super(OIDCSecurityManager, self).__init__(appbuilder)
        if self.auth_type == AUTH_OID:
            self.oid = OpenIDConnect(self.appbuilder.get_app)
        self.authoidview = AuthOIDCView

if __name__ == '__main__':
    from flask import Flask
    from flask_appbuilder import AppBuilder

    app = Flask(__name__)
    app.config['SECRET_KEY'] = 'mysecretkey'
    app.config['AUTH_TYPE'] = AUTH_OID

    db = None  # Initialize your database here

    appbuilder = AppBuilder(app, db)
    security_manager = OIDCSecurityManager(appbuilder)

    app.run(debug=True)