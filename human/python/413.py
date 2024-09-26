def mydecorator(func):
    print("""
    this is the outer decorator code 
    and will be executed when the decorator
    is applied (most often - but not necessarily
    - at import time)
    """)
    def wrapper(*args, **kw):
        print("""
        this is the inner decorator code     
        which is only executed when the
        decorated function is called,
        so here it's safe to do whatever
        you would do in the decorated function.
        """)
        return func(*args, **kw)
    return wrapper

@mydecorator
def add(a, b):
    return a + b

result = add(3, 5)
print(result)