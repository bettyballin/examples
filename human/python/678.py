x = 12345678901234567890
y = 98765432109876543210

x_32 = x.to_bytes(32, 'big')
y_32 = y.to_bytes(32, 'big')

print(x_32)
print(y_32)