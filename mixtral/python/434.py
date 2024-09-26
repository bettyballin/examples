from flask import Flask, request, jsonify
from cryptography.fernet import Fernet

app = Flask(__name__)
fernet = Fernet.generate_key()

@app.route('/decode', methods=["POST"])
def decode():
    response = {'encoded_text': request.json['encoded_text']}
    text = bytes(response['encoded_text'], 'utf-8')  
    decryptedbytes = fernet.decrypt(text)
    decryptedstr = decryptedbytes.decode('utf-8')
    return jsonify({'decoded_text': decryptedstr})

if __name__ == '__main__':
    app.run(debug=True)