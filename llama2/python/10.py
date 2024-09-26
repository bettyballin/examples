import numpy as np

class GF28(np.ndarray):
    def __new__(cls, value=0):
        return np.ndarray.__new__(cls, (1, ), dtype=np.int32)

    def __init__(self, value=0):
        self.value = value
        self[0] = value

    def __add__(self, b):
        if isinstance(b, GF28):
            return GF28(ops.add(self.value, b.value))
        else:
            raise NotImplementedError

    def __sub__(self, b):
        if isinstance(b, GF28):
            return GF28(ops.sub(self.value, b.value))
        else:
            raise NotImplementedError

    def __mul__(self, b):
        if isinstance(b, GF28):
            return GF28(ops.mul(self.value, b.value))
        else:
            raise NotImplementedError

    def __truediv__(self, b):
        if isinstance(b, GF28):
            return GF28(ops.truediv(self.value, b.value))
        else:
            raise NotImplementedError

class Ops:
    @staticmethod
    def add(a, b):
        return (a + b) % 256

    @staticmethod
    def sub(a, b):
        return (a - b) % 256

    @staticmethod
    def mul(a, b):
        return (a * b) % 256

    @staticmethod
    def truediv(a, b):
        if b == 0:
            raise ZeroDivisionError("Cannot divide by zero")
        return (a * pow(b, -1, 256)) % 256

ops = Ops()

# Test the code
a = GF28(10)
b = GF28(20)
print("Addition: ", (a + b).value)
print("Subtraction: ", (a - b).value)
print("Multiplication: ", (a * b).value)
print("Division: ", (a / b).value)