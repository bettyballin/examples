
def add_padding(base32_str):
    return base32_str + '=' * ((8 - len(base32_str) % 8) % 8)

# When you need to decode:
padded_secret = add_padding(secret)
# Now you can decode `p
