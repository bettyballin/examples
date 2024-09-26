from Cryptodome.Hash import SHA256

def generate_hash(key):
    return SHA256.new(data=key.encode()).hexdigest()

# Generate hash for serial key
serial_key = "user-specific-serial"
hashed_serial = generate_hash(serial_key)

# Store hashed value in database
# For demonstration purposes, we'll use a variable instead of a database
stored_hash = hashed_serial

# Later when user enters their license:
entered_license = input('Enter your License Key: ')
entered_hash = generate_hash(entered_license)

if entered_hash == stored_hash:
    print("License is valid!")
else:
    print("Invalid License. Please try again.")