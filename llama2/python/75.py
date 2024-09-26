import base64

encoded_text = "YOUR_ENCODED_TEXT"

# Remove any extraneous characters from the end of the encoded text
encoded_text = encoded_text[:-11]

decoded_text = base64.b64decode(encoded_text)

print(decoded_text.decode('utf-8'))