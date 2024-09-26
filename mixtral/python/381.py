from sympy import primerange, divisors, isprime

def euler_totient(n):
    phi = n

    # Generate primes up to sqrt of n
    p = list(primerange(1, int(n**0.5) + 2))

    for i in range(len(p)):
        if pow(p[i], 2) > n:
            break

        # If divisor is a prime factor
        while n % p[i] == 0:

           phi = int((phi * (1 - 1/float(p[i]))))

           # Update n
           n /= float(p[i])

    if n > 1 and not isprime(n):
        for i in divisors(int(n)):
            if i != 1:
                phi = int((phi * (1 - 1/float(i))))

    return int(phi)

# Test the function
print(euler_totient(10))