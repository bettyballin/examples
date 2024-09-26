hex_string = "1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736"

num_of_bits = len(hex_string) * 4

binary_string = bin(int(hex_string, 16))[2:].zfill(num_of_bits)

# list of english characters
chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

# list comprehension, creating binary forms of above characters,
# making them 8 bits long by adding zeroes to the beginning
binary_chars = [format(ord(char), 'b').zfill(8) for char in chars]

def adjust_key_length(message, key):
    multiplier = int(len(message) / len(key))
    modulo = len(message) % len(key)
    adjusted_key = multiplier * key  + key[0:modulo]
    return adjusted_key

# added main function to test the code
def main():
    print("Binary representation of hex string: ", binary_string)
    print("Adjusted key example: ", adjust_key_length(binary_string, "10101010"))

if __name__ == "__main__":
    main()