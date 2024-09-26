class DONT:
    def __init__(self, size, pattern):
        self.pattern = pattern
        self.size = size
    def __str__(self):
        return self.pattern * self.size

# Test the class
obj = DONT(5, "*")
print(obj)