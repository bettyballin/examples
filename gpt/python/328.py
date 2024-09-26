
def mod_inverse(a, p):
    # Function to find the modular inverse
    # Fermat's little theorem for prime p: a^(p-1) ≡ 1 (mod p)
    # a^(p-2) ≡ a^(-1) (mod p)
    return pow(a, p - 2, p)

def mod_sqrt(a, p):
   
