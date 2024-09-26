import os

folder_path = "MyFolder"
username = os.environ["USERNAME"]

# Get the current permissions
permissions = oct(os.stat(folder_path).st_mode)[-3:]

# Set read and write access for owner only
new_permissions = int("700", 8)

try:
    os.chmod(folder_path, new_permissions)
except Exception as e:
    print(f"Error setting permissions: {e}")