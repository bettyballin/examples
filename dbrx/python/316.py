def Legendre(arr, modulo):
    exponent = (modulo-1)//2
    for i in range(len(arr)):
        candidate = pow(int(arr[i]), exponent, modulo)
        print("{} : {}".format(arr[i], candidate))

# example usage:
arr = [1, 2, 3, 4, 5]
modulo = 7
Legendre(arr, modulo)