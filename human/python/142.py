import random as rnd

class Random:
    def seed(self, x=None):
        rnd.seed(x)

    def random(self):
        return rnd.random()

    def uniform(self, a, b):
        return rnd.uniform(a, b)

    def triangular(self, low=0.0, high=1.0, mode=None):
        return rnd.triangular(low, high, mode)

    def randint(self, a, b):
        return rnd.randint(a, b)

_inst = Random()
seed = _inst.seed
random = _inst.random
uniform = _inst.uniform
triangular = _inst.triangular
randint = _inst.randint