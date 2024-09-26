# Assuming 'group' and 'msg' are defined elsewhere in the code

# Decode the message from GT element into an integer using decode method
decoded_message = group.decode(msg)

# Convert decoded integer value (bytes) of "Hello world!" as a string
message_str = str(decoded_message, 'utf-8')

print(f"Decoded Message: {message_str}")