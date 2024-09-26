def Enc(c, e, n):
    return pow(c, e, n)

def Dec(c, d, n):
    return pow(c, d, n)

def execute():
    c2 = 10  # example value
    e2 = 3   # example value
    n2 = 33  # example value
    d1 = 7   # example value
    n1 = 33  # example value

    r1 = Enc(c2, e2, n2)
    r2 = Dec(r1, d1, n1)
    return r2

print(execute())