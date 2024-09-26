import time
import hashlib

def print_progress():
    for i in range(1, 101):
        print(f"{i}% done")
        time.sleep(0.1)  # wait for 0.1 seconds

print_progress()

print(hashlib.md5("100% done".encode()).hexdigest())