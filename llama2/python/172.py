from decimal import Decimal, getcontext

# Set the precision
getcontext().prec = 1000

# Define the values
a = Decimal('15653')
b = Decimal('923')
k = Decimal('-3632')
p = Decimal('262643')

# Perform the calculation
m = (b**int(k) * a) % p

print(m)