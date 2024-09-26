def decryption_keys_affine(p1, p2, C1, C2, AL):
    def extended_euclidean(a, b):
        if a == 0:
            return b, 0, 1
        else:
            gcd, x, y = extended_euclidean(b % a, a)
            return gcd, y - (b // a) * x, x

    def inverse_mod(a, m):
        gcd, x, y = extended_euclidean(a, m)
        if gcd != 1:
            return "These are not co-prime."
        else:
            return x % m

    s = inverse_mod(p1 - p2, AL) * (C1 - C2)

    if isinstance(s, int):
        r = (inverse_mod(s, AL) * C2 - p2) % AL
        print("INV(S):", inverse_mod(s, AL), "+ R:", r)

    else:
        print(s)