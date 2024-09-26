import hashlib
import os

def digest_with_progress(filename, chunk_size):
    read_size = 0
    last_percent_done = 0
    digest = hashlib.md5()
    total_size = os.path.getsize(filename)

    data = True
    with open(filename, 'rb') as f:
        while data:
            # Read and update digest.
            data = f.read(chunk_size)
            read_size += len(data)
            digest.update(data)

            # Calculate progress.
            percent_done = 100 * read_size / total_size
            if percent_done > last_percent_done:
                print('%d%% done' % percent_done)
                last_percent_done = percent_done
    return digest.hexdigest()

# Example usage
filename = 'example.txt'
chunk_size = 1024
print(digest_with_progress(filename, chunk_size))