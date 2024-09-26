import os
import mmap

# In one script
size = 1024
fd = os.open("/dev/shm/NAME", os.O_RDWR | os.O_CREAT | os.O_EXCL)
os.write(fd, b'\x00' * size)
os.close(fd)

buffer = mmap.mmap(-1, size, tagname="NAME")

# Write data to buffer
buffer.write(b'Hello, world!')
buffer.close()

# Now in another Python shell
import mmap

existing_mm = mmap.mmap(-1, 1024, "NAME", access=mmap.ACCESS_READ)

data = existing_mm[:]
print(data)
existing_mm.close()