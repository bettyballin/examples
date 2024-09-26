def adjust_key_length(message, key):
    multiplier = len(message) // len(key)
    modulo = len(message) % len(key)
    adjusted_key = multiplier * key + key[0:modulo]
    return adjusted_key

message = "110111101010"
key = "01100001"

print(adjust_key_length(message, key))