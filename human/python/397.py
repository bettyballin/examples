def find_public_key_exponent(euler_function):
    """
    find_public_key_exponent(euler_function)

    Finds public key exponent needed for encrypting.
    Needs specific number in order to work properly.

    :param euler_function: the result of euler function for two primes.
    :return:               public key exponent, the element of public key.
    """

    e = 3

    while e <= 65537:
        a = euler_function
        b = e

        while b:
            a, b = b, a % b

        if a == 1:
            return e
        else:
            e += 2

    raise Exception("Can't find e!")

# Example usage:
euler_result = 323  # Replace with your actual euler function result
public_exponent = find_public_key_exponent(euler_result)
print(public_exponent)