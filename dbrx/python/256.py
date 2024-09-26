def power_mod(a, b, p):
    result = 1
    while (b > 0):
        if ((b % 2) == 1): 
            result = (result * a) % p  
            b -= 1

        a = (a ** 2) % p   
        b //= 2
        
    return result % p

# Test the function
print(power_mod(2, 3, 5))