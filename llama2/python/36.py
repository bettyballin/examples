import os
import re

def validate_path(path):
    # Allow only absolute paths starting with '/'
    if not path.startswith('/'):
        return False

    # Disallow '..' or any other directory traversal characters
    if re.search(r'[^\\w/]', path):
        return False

    return True

# Test the function
if __name__ == "__main__":
    print(validate_path("/home/user/documents"))  # Expected: True
    print(validate_path("home/user/documents"))   # Expected: False
    print(validate_path("/home/user/../documents")) # Expected: False
    print(validate_path("/home/user/./documents"))  # Expected: True