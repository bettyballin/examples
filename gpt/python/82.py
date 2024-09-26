
import os
import shutil

def secure_delete(user_input, base_path):
    # Normalize the base path to ensure it's an absolute path
    base_path = os.path.normpath(base_path)
    base_path = os.path.realpath(base_path)

    # Join the base path and user input, then normalize and get the real path
    full_path = os.path.join(base_path, user_input)
    full_path = os.path.normpath(full_path)
    full_path = os.path.realpath(full_path)

    # Check if the full path starts with the base path
    if not full_path.startswith(base_path):
        raise ValueError("The specified path is not
