def extended_euclidean_algorithm(a, b):
    """
    extended_euclidean_algorithm(a, b)

    The result is the largest common divisor for a and b.

    :param a: integer number
    :param b: integer number
    :return:  the largest common divisor for a and b
    """

    if a == 0:
        return b, 0, 1
    else:
        g, y, x = extended_euclidean_algorithm(b % a, a)
        return g, x - (b // a) * y, y


def modular_inverse(e, t):
    """
    modular_inverse(e, t)

    Counts modular multiplicative inverse for e and t.

    :param e: in this case e is a public key exponent
    :param t: and t is an Euler function
    :return:  the result of modular multiplicative inverse for e and t
    """

    g, x, y = extended_euclidean_algorithm(e, t)

    if g != 1:
        raise Exception('Modular inverse does not exist')
    else:
        return x % t


if __name__ == "__main__":
    a = 240
    b = 46
    e = 17
    t = 3120

    print("Extended Euclidean Algorithm result for {} and {}: {}".format(a, b, extended_euclidean_algorithm(a, b)))
    print("Modular Inverse result for {} and {}: {}".format(e, t, modular_inverse(e, t)))