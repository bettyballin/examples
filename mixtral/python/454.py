import ast
import base64

ciphertext = base64.b64decode("...")
# Convert the byte string to a list of strings
str_list = ciphertext.split(b',')

# Use map function with int and join them into bytes
bytearray_output = bytearray(map(int, str_list))