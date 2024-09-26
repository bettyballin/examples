
from cryptography.fernet import Fernet
import csv

key_file_path = "Keys.txt"

# Check if the key exists and is valid
def is_key_valid(key):
    try:
        Fernet(key)
        return True
    except ValueError:
        return False

# Read the key or generate a new one
def get_or_create_key(file_path):
    try:
        with open(file_path, "r") as csvfile:
            reader = csv.reader(csvfile)
            for row in reader:
                if row and is_key_valid(row[0].encode()):
                    return row[0].encode()
    except FileNotFoundError:
        pass
    
    # If we reach here, the key was not found
