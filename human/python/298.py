#!/usr/bin/env python

'''
AUTHENTICATION
'''
AUTH_TYPE = "AUTH_OID"
OIDC_CLIENT_SECRETS = 'client_secret.json'
OIDC_ID_TOKEN_COOKIE_SECURE = False
OIDC_REQUIRE_VERIFIED_EMAIL = False
from flask_appbuilder.security.manager import OIDCSecurityManager
CUSTOM_SECURITY_MANAGER = OIDCSecurityManager
AUTH_USER_REGISTRATION = True
AUTH_USER_REGISTRATION_ROLE = 'Gamma'