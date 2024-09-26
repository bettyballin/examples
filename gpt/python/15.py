
import random

def generate_promo_code(length=7):
    # Generate a random number with the specified length
    number = ''.join([str(random.randint(0, 9)) for _ in range(length)])
    
    # Calculate a simple checksum digit
    checksum = sum(int(digit) for digit in number) % 10
    
    # Combine the random number with the checksum
    promo_code = f"{number}-{checksum}"
    return promo_code

# Example usage:
for _ in range(5):
    print(generate_promo_code())

