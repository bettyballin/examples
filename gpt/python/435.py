
from flask import Flask, jsonify, request
from cryptography.fernet import Fernet, InvalidToken

app = Flask(__name__)
key = Fernet.generate_key()
fernet = Fernet(key)

@app.route('/decode', methods=["POST"])
def decode():
    try:
        # Get the encoded text from the request and ensure it is in bytes
        text = request.json['encoded_text']
        if isinstance(text, str):
            text = text.encode()  # Convert string to bytes
        
        # Decrypt the bytes
        decryptedbytes = fernet.decrypt(text)
        
        # Decode bytes to a UTF-8 string
        decryptedstr = decryptedbytes.decode('utf-8')
        
        # Return the decrypted string
        return jsonify(decrypted=decryptedstr)
    except InvalidToken:
        return jsonify(error="Invalid
