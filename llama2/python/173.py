import mpmath

def main():
    # Define the values
    a = mpmath.mpf('15653')
    b = mpmath.mpf('923')
    k = mpmath.mpf('-3632')
    p = mpmath.mpf('262643')

    # Perform the calculation
    m = pow(int(b), int(-k), int(p)) * int(a) % int(p)

    print(m)

if __name__ == "__main__":
    main()