import math

def extended_euclidean(a, b):
    if a % b == 0:
        return [b, 0]

    else:
        q = int(math.floor((1.*a)/b))

        r = a - (q * b)

        s = extended_euclidean(b, r)[1]

        t = extended_euclidean(b, r)[0]

    return [t, s-(q*extended_euclidean(b, r)[1])]

def find_a(res, b, c):
    # Calculate Euler's totient function
    phi = sum([i for i in range(c) if math.gcd(i, c) == 1])

    # Check condition
    gcd_val = math.gcd(b, phi)

    if (gcd_val != 1):
        print("No solution exists.")

    else:

        [inverse, _] = extended_euclidean(b, c)

        a = pow((res * inverse), b-2, c)

        return a

# Test the function
res = 3
b = 5
c = 7
print(find_a(res, b, c))