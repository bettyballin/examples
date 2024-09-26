
import os

def secure_filename(base_directory, user_input):
    # Join the base directory and the user-provided path
    full_path = os.path.join(base_directory, user_input)
    # Normalize the path to remove any ../ or similar components
    normalized_path = os.path.normpath(full_path)
    # Ensure the base directory is the prefix of the normalized path
    if os.path.commonprefix([normalized_path, base_directory]) != base_directory
