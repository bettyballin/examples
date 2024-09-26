import os
import re

def secure_filename(filename):
    # Validate format (alphanumeric hyphens underscores)
    valid_format = re.match(r'^[a-zA-Z0-9_-]+$', filename)

    if not valid_format:
        raise ValueError("Invalid filename format")

    # Normalize path and check for directory traversal
    resolved_path = os.path.abspath(os.path.join(root_folder, filename))
    
    if root_folder != os.path.commonpath((root_folder, resolved_path)):
        raise PermissionError(f"Access denied to {resolved_path}")

    return resolved_path

# Set your controlled access folder here
root_folder = "/var/www/myapp/files"

filename = "example.txt"
print(secure_filename(filename))  # Returns: /var/www/myapp/files/example.txt

bad_filename = "../creditCardInfo.xls"
try:
    secure_filename(bad_filename)
except PermissionError as e:
    print(e)  # Access denied to /path/to/parent_folder/creditCardInfo.xls