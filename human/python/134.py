import random

original_str = "Hello, World!"
str_key = "my_secret_key"

# Convert string to list
msg = list(original_str)

random.seed(str_key)
random.shuffle(msg)
print("".join(msg))