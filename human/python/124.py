import gmpy2

def unpack(x, b):
    try:
        return [int(x) for x in gmpy2.unpack(gmpy2.mpz(x), b)]
    except NameError:
        b = 2 ** b
        r = []
        while x:
            x, temp = divmod(x, b)
            r.append(temp)
        return r

print(unpack(123456**7, 15))

del gmpy2

print(unpack(123456**7, 15))