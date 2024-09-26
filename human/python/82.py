import ctypes

# Define a function to get the memory address of
def foo():
    pass

arr = (ctypes.c_ubyte * 64).from_address(id(foo))

print(arr)