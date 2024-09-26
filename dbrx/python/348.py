from mmap import mmap, ACCESS_READ
from pickle import load, dump
import os

mm = mmap(-1, 32, tagname='Global\\test', access=ACCESS_READ)

last_request_id = None
while True:
    mm.seek(0)
    try:
        request_id = int(load(mm))
        if request_id != last_request_id:
            last_request_id = request_id
            print(request_id)        
    except Exception as e:
        pass

Note: I fixed the import statements, added the missing `import os` and corrected the `mmap` call. I also removed the `client.py` at the end as it's not a valid Python statement.