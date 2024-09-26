import itsdangerous

s = itsdangerous.URLSafeSerializer('secret-key', 'salt')
token = 'your-token-here'

try:
    data = s.loads(token)
except itsdangerous.SignatureExpired:
    # Handle expired tokens here...
    print("Signature has expired")
except itsdangerous.BadSignature:
    # Handle invalid signatures here...
    print("Bad signature")
else:
    user_id = data['id']
    print(f"User ID: {user_id}")