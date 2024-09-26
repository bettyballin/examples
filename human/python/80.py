def Foo(param):
    param = [param]  
    class _Foo(object):
        @property
        def param(self):
            return param[0]
        @param.setter
        def param(self, val):
            param[0] = val
    return _Foo()

foo = Foo('bar')
print(foo.param)  
foo.param = 'baz'
print(foo.param)