
def vernam_cipher(binary_str1, binary_str2):
    # Convert binary strings to integers
    num1 = int(binary_str1, 2)
    num2 = int(binary_str2, 2)

    # XOR the two numbers
    result_num = num1 ^ num2

    # Convert the result back to a binary string, removing the '0b' prefix
    result_bin = bin(result_num)[2:].zfill(len(binary_str1))

    return result_bin

# Example usage:
binary_str1 = '1101'
binary_str2 = '1011'
result = vernam_cipher(binary_str1, binary_str2)
print(result)  # Output should be '0110'

