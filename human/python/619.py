data = "username|password"
credentials = data.split("|", 1)
if len(credentials) == 2:
    user, passw = credentials
else:
    print("this is not what I expected")