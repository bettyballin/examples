import os
import hashlib
import hmac

# Generate a random nonce value
nonce = os.urandom(16).hex()

# Set the Content-Security-Policy header
csp_header = f"script-src 'self' 'nonce-{nonce}'; style-src 'self' 'nonce-{nonce}';"

# Generate a hash-source for a script
script_content = "console.log('Hello World!');"
script_hash = hashlib.sha256(script_content.encode()).hexdigest()

# Generate a hash-source for a style
style_content = "body { background-color: #f2f2f2; }"
style_hash = hashlib.sha256(style_content.encode()).hexdigest()

# Update the Content-Security-Policy header with hash-sources
csp_header += f" script-src '{script_hash}'; style-src '{style_hash}';"

print(csp_header)