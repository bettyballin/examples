
from cryptography.fernet import Fernet
import csv

# Read the existing key or create a new one if not found
key_found = False
try:
    with open("Keys.txt", "r+") as csvfile:
        reader = csv.reader(csvfile)
        for row in reader:
            if len(row) > 0:
                key = row[0]
                key_found = True
                break
except FileNotFoundError:
    pass

# Create a new key if one wasn't found
if not key_found:
    key = Fernet.generate_key().decode()  # Convert bytes to string
    with open("Keys.txt", "w") as csvfile:
        writer = csv.writer(csvfile)
        writer.writerow([key])  # Write the string key

