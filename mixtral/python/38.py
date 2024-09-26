class IVCounter:
    def __init__(self, initial_value):
        # Convert hex string into byte array
        self._counter = int(initial_value, 16)

# Test the class
iv = IVCounter("1234567890abcdef")
print(iv._counter)