
import math

def find_largest_odd_factor_of_bit_length(N, N_MAX_FACTOR_BITSIZE):
    # Calculate the largest possible value with N_MAX_FACTOR_BITSIZE bits
    max_factor = (1 << N_MAX_FACTOR_BITSIZE) - 1
    # Ensure the number is odd
    if max_factor % 2 == 0:
        max_factor -= 1
    # Iterate from the largest possible odd value down to the square root of N
    for factor in range(max_factor, int(math.sqrt(N)), -2):
        if N % factor == 0:
            return factor
    return None

N = 9868690954602957859
N_MAX_FACTOR_BITSIZE = 64
largest_odd_factor = find_largest_odd_factor_of_bit_length(N, N
