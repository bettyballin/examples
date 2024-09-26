
def adjust_key_length(message, key):
    multiplier = len(message) // len(key)  # Integer division
    modulo = len(message) % len(key)
    adjusted_key = (key * multiplier) + key[:modulo]
    return adjusted_key

message = "110111101010"
key = "01100001"

adjusted_key = adjust_key_length(message, key)
# Now you can XOR the message with the adjusted_key

