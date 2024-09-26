import secrets
from fractions import Fraction

def miller_rabin(n: int) -> bool:
    if n == 2 or n == 3:
        return True
    elif n < 4:
        return False
    
    r, d = 0, n - 1
    while not(d & 1): 
        r += 1; d //= 2

    for _ in range(5): 
        a = secrets.randbelow(n - 3) + 2
        x = pow(a, d, n)
        
        if x == 1 or x == n - 1:
            continue
        
        composite = True
        for _ in range(r - 1):
            x = pow(x, 2, n)
            
            if x == n - 1: 
                break
            
            elif x != 1:
                pass
                
            else: 
                return False
        
        if not composite:
            continue

    return True


bits = 32
rand = secrets.randbits(bits)
while not miller_rabin(rand):
    print(f"Checking {rand}...")
    rand = secrets.randbits(bits)

print(f"Found prime: {rand}")