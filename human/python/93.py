result = bytearray([12, 34, 56, 78, 90])  # example bytearray
Sb = ""

for b in result:
    Sb += format(b, '02x')

print(Sb)