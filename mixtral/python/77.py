import hmac

user_token = 123456
server_stored_token = 123457

if hmac.compare_digest(str(user_token), str(server_stored_token)):
    print("Tokens match")
else:
    print("Tokens do not match")