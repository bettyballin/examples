import hashlib

username = "LoginUser"
password = "LoginPass"

# SHA256(username)
sha256_username = hashlib.sha256(username.encode()).hexdigest()
print(f"SHA256(username={username}) = {sha256_username}")

# SHA1(password)
sha1_password = hashlib.sha1(password.encode()).hexdigest()
print(f"SHA1(password={password}) = {sha1_password}")

# SHA256(username + password)
sha256_userpass = hashlib.sha256((username + password).encode()).hexdigest()
print(f"SHA256((username + password)={username}{password}) = {sha256_userpass}")