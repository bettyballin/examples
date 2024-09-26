
import hashlib
import os

def generate_md5(file_path, chunk_size=8192):
    file_size = os.path.getsize(file_path)
    md5 = hashlib.md5()
    bytes_processed = 0

    with open(file_path, 'rb') as f:
        while chunk := f.read(chunk_size):
            md5.update(chunk)
            bytes_processed += len(chunk)
            percent_done = (bytes_processed / file_size) * 100
            print(f"{percent_done:.2f}% done...")

    return md5.hexdigest()

# Usage
file = 'path_to_large_video_file'
checksum = generate_md5(file)
print(f"The MD5 checksum is: {checksum}")

