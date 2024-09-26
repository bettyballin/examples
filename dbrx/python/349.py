from mmap import mmap, ACCESS_READ
from pickle import dump, load

with mmap(-1, 32, tagname='Global\\test', access=ACCESS_READ) as mm:
    try:
        # Read the request id from shared memory.
        last_request_id = int(load(mm))
    except Exception as e:
        pass