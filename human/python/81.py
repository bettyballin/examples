class Foo:
    def __init__(self):
        self._param = None

    @property
    def param(self):
        return self._param

    @param.setter
    def param(self, value):
        self._param = value

foo = Foo()
foo.param = 'bar'

foo.__class__.param.fget.__closure__[0].cell_contents[0] = 'hey'
print(foo.param)