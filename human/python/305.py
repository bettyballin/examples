def hex_to_binary(text):
    return '{:0{}b}'.format(int(text, base=16), len(text) * 4)

# Test the function
text = input("Enter a hexadecimal number: ")
print(hex_to_binary(text))