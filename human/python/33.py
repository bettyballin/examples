import numpy as np

class GF28:
    def __init__(self, value):
        self.value = value % 28

    def __repr__(self):
        return f"GF28({self.value})"

a = np.array([(GF28(10), GF28(20), GF28(30)),
              (GF28(12), GF28(21), GF28(4)),
              (GF28(9), GF28(16), GF28(13))],dtype='object')