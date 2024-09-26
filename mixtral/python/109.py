def discrete_logarithm(p, g, t, d, j, k):
    if d != 1:
        inversed = pow(j[1]-k[1], -1, (p - 1) // d)
        l = ((k[2]-j[2]) * inversed) % ((p - 1) // d)
        m = 0

        while m <= d:
            gl_p = pow(g, l, p)
            print(m, l)

            if gl_p == t:
                return l

            m += 1
            l = (l + ((p - 1) // d)) % (p-1)

        else:
            # If no solution is found after the loop
            return None

    else:
        print("No discrete logarithm exists for this input.")

    return False