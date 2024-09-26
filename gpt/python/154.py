
def point_scalar_multiplication_double_and_add(a, b, p, x, y, scalar):
    """
    Implement Point multiplication with a scalar using Montgomery Ladder
    which is constant time with respect to the scalar value.
    """
    R0 = (None, None)  # Represents the point at infinity.
    R1 = (x, y)

    # Ensure we have a fixed number of iterations
    num_bits = scalar.bit_length()  # Assuming scalar is an integer
    for i in reversed(range(num_bits)):
        bit = (scalar >> i) & 1
        if bit == 1:
            R0 =
