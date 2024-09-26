
import tarfile
import io

# Constants to configure the limits
MAX_FILES = 1000
MAX_UNCOMPRESSED_SIZE = 100 * 1024 * 1024  # 100 MB
MAX_FILE_SIZE = 10 * 1024 * 1024  # 10 MB
MAX_COMPRESSION_RATIO = 100

def is_gzip_bomb(fileobj, max_files=MAX_FILES,
                 max_uncompressed_size=MAX_UNCOMPRESSED_SIZE, 
                 max_file_size=MAX_FILE_SIZE, 
                 max_compression_ratio=MAX_COMPRESSION_RATIO):
    """
    Checks if the file-like object is a gzip or bzip2 bomb.
    """
    uncompressed_size = 0
   
