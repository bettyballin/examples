class MyObject:
    def __init__(self, int1, str1, int2, str2):
        self.data = frozenset([int1, str1, int2, str2])

obj1 = MyObject(10, "hello", 5, "world")
obj2 = MyObject(5, "world", 10, "hello")

print(hash(obj1.data) == hash(obj2.data))