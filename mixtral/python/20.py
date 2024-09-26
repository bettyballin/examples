import math
import os
import string
import random

Starting_number = 100
Ending_number = 1000

prime_numbers = []

for num in range(Starting_number, Ending_number + 1):
    if all(num % i != 0 for i in range(2, int(math.sqrt(num)) + 1)):
        prime_numbers.append(str(num))

random_prime = random.choice(prime_numbers)

password_lengths = {
    4: (Starting_number, 100),
    8: (101, Ending_number)
}

password_length = next((length for condition, length in password_lengths.items() if condition <= int(random_prime) < length[1]), 4)

password = ''.join(random.choice(string.ascii_letters + string.digits + "!@#$%^&*()") for _ in range(password_length))

print("Random prime number: ", random_prime)
print("Generated Password: ", password)