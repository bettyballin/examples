def generate_gold_code(n):
    # Initialize two shift registers A and B both n-bits long.
    register_a = [1] * (n // 2)
    register_b = [0] + ([0] * ((n - 3) // 2)) + [1]

    for _ in range(15):
        # Calculate the output bit as XOR of last bits from both registers
        out_bit = register_a[-1] ^ register_b[-1]
        
        # Shift all elements to left by one position.
        shifted_register_a = [register_a[i+1] if i < n // 2 - 1 else out_bit for i in range(n // 2)]
        register_a = shifted_register_a
        shifted_register_b = [register_b[i+1] if i < (n-3)//2 else register_b[i] for i in range((n-1)//2)] + [out_bit]
        register_b = shifted_register_b

    return out_bit, register_a, register_b[1:] + [out_bit]

# example usage:
n = 8
out_bit, register_a, register_b = generate_gold_code(n)
print("Output bit:", out_bit)
print("Final Register A:", register_a)
print("Final Register B:", register_b)