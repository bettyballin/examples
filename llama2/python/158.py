import paramiko
import nacl

# Load the OpenSSH private key file
with open('path/to/private_key', 'r') as f:
    private_key = f.read()

# Parse the private key using Paramiko
ssh_key = paramiko.RSAKey.from_private_key_file('path/to/private_key')

# Extract the actual private key from the SSH format
private_key_bytes = ssh_key.get_name() + b' ' + ssh_key.get_base64()

# Use the extracted private key with NaCl
nacl_private_key = nacl.signing.SigningKey.generate(curve=nacl.signing.SECP256R1)