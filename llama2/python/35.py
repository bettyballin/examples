import numpy as np
from PIL import Image
import base64

# Load the image
img = Image.open('imagefile.jpg')

# Extract the color palette
img = img.convert('RGB')
pixels = list(img.getdata())

# Encode the hidden file into a binary format
hidden_data = 'your_secret_message_here'
encoded_data = base64.b64encode(hidden_data.encode())

# Convert the encoded data into an integer array
encoded_data_int = np.frombuffer(encoded_data, dtype=np.uint8)

# Insert the encoded data into the least significant bits of each color component
encoded_index = 0
for i in range(len(pixels)):
    pixel = pixels[i]
    red, green, blue = pixel
    # Insert the encoded data into the least significant 2 bits of each color component
    if encoded_index < len(encoded_data_int):
        red = (red & 0xFC) | (encoded_data_int[encoded_index] >> 6)
        encoded_index += 1
    if encoded_index < len(encoded_data_int):
        green = (green & 0xFC) | ((encoded_data_int[encoded_index] >> 2) & 0x3)
        encoded_index += 1
    if encoded_index < len(encoded_data_int):
        blue = (blue & 0xFC) | (encoded_data_int[encoded_index] & 0x3)
        encoded_index += 1
    pixels[i] = (red, green, blue)

# Save the modified image
img.putdata(pixels)
img.save('modified_image.jpg')