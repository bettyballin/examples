from BitVector import BitVector

bv = BitVector(intVal = 0x13A5, size = 32)
print(bv)
bv = bv << 6
print(bv)
bv[0] = 1
print(bv)
bv = bv << 3
print(bv)