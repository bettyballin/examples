class DuplicateFileException(Exception):
    pass

def ObtainTable():
    # Simulating a database or hash map
    return {}

def hash_for_tile(file):
    # Simulating a hash function
    import hashlib
    hash = hashlib.sha256(file.read()).hexdigest()
    nchunks = 1  # Replace with actual chunk calculation
    return hash, nchunks

def store_file(file, nchunks, hash, big_table):
    if nchunks in big_table:
        if hash in big_table[nchunks]:
            raise DuplicateFileException('File is dup with %s' % big_table[nchunks][hash])
    else:
        big_table[nchunks] = {}

    big_table[nchunks].update({
        hash: file.filename
    })

    # Simulating a file save
    print(f"File {file.filename} saved")

class File:
    def __init__(self, filename, content):
        self.filename = filename
        self.content = content

    def read(self):
        return self.content

    def save(self):
        pass

# Usage
new_file = File("test.txt", b"Hello, World!")
new_file_hash, nchunks = hash_for_tile(new_file)
big_table = ObtainTable()
store_file(new_file, nchunks, new_file_hash, big_table)