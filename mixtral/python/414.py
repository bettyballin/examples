def Legendre(arr, modulo):
    exponent = ((modulo-1)//2)
    for i in range(len(arr)):
        candidate = pow(int(arr[i]), int(exponent), modulo)

        # If a is divisible by p
        if candidate == 0:
            print("{} : {} (Divisibility)".format(-1, arr[i]))

        elif candidate % modulo > ((modulo-1)//2):
             print("{} : {}".format(candidate - modulo, arr[i]))

        else:
            print("{} : {} (Quadratic Residue)".format(candidate, arr[i]))

arr = [int(x) for x in input("Enter space-separated integers: ").split()]
modulo = int(input("Enter modulo: "))
Legendre(arr, modulo)