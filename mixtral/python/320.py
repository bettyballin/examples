from cryptography.fernet import Fernet
import json
import base64

if __name__ == "__main__":
    # Generate a key
    key = Fernet.generate_key()

    # Create a Fernet object
    cipher_suite = Fernet(key)

    # Data to encrypt
    data = {
        "message": "This is a secret message"
    }

    # Convert data to JSON
    json_data = json.dumps(data).encode('utf-8')

    # Encrypt data
    encrypted_data = cipher_suite.encrypt(json_data)

    # Decrypt data
    decrypted_data = cipher_suite.decrypt(encrypted_data)

    # Print results
    print("Key:", key)
    print("Encrypted Data:", encrypted_data)
    print("Decrypted Data:", json.loads(decrypted_data.decode('utf-8')))