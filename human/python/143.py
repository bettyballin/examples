import _random

class Random(_random.Random):
    def __init__(self, x=None):
        self.seed(x)

_inst = Random()
seed = _inst.seed

if __name__ == "__main__":
    seed(12345)
    print(_inst.random())