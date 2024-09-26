import string
import random
import os

# Password generator

Starting_number = 1
Ending_number = 10
num = 100

length = int((Ending_number / Starting_number) * 5 + 11)
if length >= num:
    length = int(num / 100)

chars = string.ascii_letters + string.digits + '!@#$%^&*()'
random.seed(os.urandom(1024))

print(''.join(random.choice(chars) for i in range(length)))