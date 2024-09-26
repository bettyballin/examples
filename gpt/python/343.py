
from passlib.context import CryptContext

# Flask-Security uses the passlib library to handle password hashing.
# Create a CryptContext object with the same configuration as your Flask-Security setup
pwd_context = CryptContext(
    schemes=["pbkdf2_sha512"],
    default="pbkdf2_sha512",
    pbkdf2_sha512__default_rounds=25000
)

# This is the hash you want to verify, taken from your database
hashed_pass = '$pbkdf2-sha512$25000$pXROaU2JUSrlnDPm3BsjBA$ckspsls2SWPhl9dY7XDiAZh5yucWq27fWRuVj4aOUc5dA2Ez5VH1LYiz5KjaZJscaJYAFhWIwPhkAsHiPOrvrg'

# The plaintext password
