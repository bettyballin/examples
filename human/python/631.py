import secrets
import string

choices = string.ascii_letters + string.digits + "<>()[*?@!#~,.;"
key = "".join(secrets.choice(choices) for n in range(100))

print(key)