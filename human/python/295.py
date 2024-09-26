import json

config = {
    "web": {
        "realm_public_key": "<YOUR_REALM_PUBLIC_KEY>",
        "issuer": "http://<YOUR_DOMAIN>/auth/realms/<YOUR_REALM_ID>",
        "auth_uri": "http://<YOUR_DOMAIN>/auth/realms/<YOUR_REALM_ID>/protocol/openid-connect/auth",
        "client_id": "<YOUR_CLIENT_ID>",
        "client_secret": "<YOUR_SECRET_KEY>",
        "redirect_urls": [
            "http://<YOUR_DOMAIN>/*"
        ],
        "userinfo_uri": "http://<YOUR_DOMAIN>/auth/realms/<YOUR_REALM_ID>/protocol/openid-connect/userinfo",
        "token_uri": "http://<YOUR_DOMAIN>/auth/realms/<YOUR_REALM_ID>/protocol/openid-connect/token",
        "token_introspection_uri": "http://<YOUR_DOMAIN>/auth/realms/<YOUR_REALM_ID>/protocol/openid-connect/token/introspect"
    }
}

print(json.dumps(config, indent=4))