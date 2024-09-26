from flask_appbuilder.security.views import AuthOIDView
from flask_login import login_user
from urllib.parse import quote, urlencode
from flask import redirect, request

class AuthOIDCView(AuthOIDView):

    @expose('/login/', methods=['GET', 'POST'])
    def login(self, flag=True):
        
        sm = self.appbuilder.sm
        oidc = sm.oid

        @self.appbuilder.sm.oid.require_login
        def handle_login(): 
            user = sm.auth_user_oid(oidc.user_getfield('email'))
            
            if user is None:
                info = oidc.user_getinfo(['preferred_username', 'given_name', 'family_name', 'email'])
                user = sm.add_user(info.get('preferred_username'), info.get('given_name'), info.get('family_name'), info.get('email'), sm.find_role('Gamma')) 
                
            login_user(user, remember=False)
            return redirect(self.appbuilder.get_url_for_index)  
       
        return handle_login()  

    @expose('/logout/', methods=['GET', 'POST'])
    def logout(self):
        
        oidc = self.appbuilder.sm.oid
        
        oidc.logout()
        super(AuthOIDCView, self).logout()        
        redirect_url = request.url_root.strip('/') + self.appbuilder.get_url_for_login
        
        return redirect(oidc.client_secrets.get('issuer') + '/protocol/openid-connect/logout?' + urlencode({'redirect_uri': redirect_url}))