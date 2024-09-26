import string
import hashlib
import random
from concurrent import futures

id = "1234"
random_string = ""
count = 0

def generate(i):
    global count

    while True:
        random_string = ''.join(random.choice(string.ascii_letters) for _ in range(10))

        hash_result = hashlib.sha256((random_string + id).encode()).hexdigest()

        if ((hash_result[0:6] == "a0eebb") and (hash_result[6:8] == id[-2:])):
            print(f"Random string generated: {random_string}")

            with open('results.txt', 'w') as f:
                f.write(f"{random_string}\nHash:{hash_result}")

        count +=1

with futures.ThreadPoolExecutor() as executor:
    for _ in range(50):
         future = executor.submit(generate, 1)