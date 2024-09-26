import hashlib
import time

def calculate_hash(input_string):
    return hashlib.md5(input_string.encode()).hexdigest()

input_string = "some_string"
expected_hash = "b114ecaab65bc5b02f5a129bd29d1864"

for i in range(10):
    print(f"{(i+1)*10}% done")
    time.sleep(0.1)  # simulate work

calculated_hash = calculate_hash(input_string)
print(f"Calculated hash: {calculated_hash}")
if calculated_hash == expected_hash:
    print("Hash matches expected value")
else:
    print("Hash does not match expected value")