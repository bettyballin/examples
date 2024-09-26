import passlib.hash
import getpass

# Get the SSN from the user
SSN = getpass.getpass("Enter your SSN: ")

# Generate a random salt
salt = passlib.hash.bcrypt.genSalt()

# Hash the SSN with bcrypt
ssn_hash = passlib.hash.bcrypt.hash(SSN, salt)

# Store ssn_hash in the database
print(ssn_hash)