def generate_gold_code(length):
    # This function is not defined in the original code, so I'll provide a simple implementation
    return [str(random.randint(0, 1)) for _ in range(length)]

def encrypt_message(message):
    gold_code = [generate_gold_code(15) for _ in range(len(message))]
    
    encrypted_text = ""
    i = 0

    while i < len(gold_code):
        if message[i] == '1':
            bit_to_xor = int(gold_code[i][0])
        else:
            bit_to_xor = int(gold_code[i][0])  # Convert to int

        xor_result = bin(ord(message[i]) ^ bit_to_xor)[2:]
        
        encrypted_text += chr(int(xor_result, 2))  # Add base 2 to int conversion
        i += 1

    return encrypted_text

import random
print(encrypt_message("101010"))