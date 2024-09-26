from multiprocessing import shared_memory

# In one script
shm = shared_memory.SharedMemory(create=True, size=1024)
buffer = shm.buf

# Write data to buffer
buffer[:10] = b'HelloWorld'

# Print the name of the shared memory block
print(shm.name)

# Now in another Python shell
import multiprocessing.shared_memory as sm

# Use the name printed above
shm_name = input("Enter the shared memory name: ")

existing_shm = sm.SharedMemory(name=shm_name, create=False)

data = existing_shm.buf[:]
print(data)