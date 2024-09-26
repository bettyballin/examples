import os

def sanitize_path(user_input):
    # Join user input with base dir (data/)
    safe_path = os.path.join('data', user_input)

    # Check that it's still within our desired root dir
    if not safe_path.startswith(os.path.abspath('data')):
        raise ValueError("Invalid path")

    return safe_path

# Usage:
user_input = input("Enter a path: ")
try:
    sanitized_path = sanitize_path(user_input)
    print(sanitized_path)
except ValueError as e:
    print(e)