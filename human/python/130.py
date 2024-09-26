with open('file.out', 'w') as output:
    for n in range(100000000):
        s = "{0:08d}".format(n)
        output.write(s[:2] + '-' + s[2:] + '\n')


Note: I replaced `xrange` with `range` since `xrange` is deprecated in Python 3.x. If you're using Python 2.x, you can keep `xrange`.