class TypeACurveGenerator:
    def __init__(self, p, n):
        self.p = p
        self.n = n

    def generate(self):
        curve = []
        for i in range(self.n):
            curve.append((i, pow(i, 2, self.p)))
        return curve

acg = TypeACurveGenerator(159, 512)
print(acg.generate())