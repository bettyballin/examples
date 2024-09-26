class Sign:
    def __init__(self, name):
        self._name = name
        self._dotted_string = None

    @property
    def dotted_string(self):
        return self._dotted_string

    @dotted_string.setter
    def dotted_string(self, value):
        self._dotted_string = value

sign = Sign("example")
print(dir(sign))