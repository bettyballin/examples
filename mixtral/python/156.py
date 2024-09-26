import binascii

def testdecrypt():
    a = 16
    e = 65537
    p = 15308793451280999927
    n = 225614505179301198794693425143200819953
    q = 14737575883906276439

    phi = (p-1)*(q-1)

    d = pow(e, -1, phi)

    with open('test.enc', 'rb') as file:
        input_bytes = bytearray(file.read())

    m = [pow(int.from_bytes(input_bytes[i:i+a], "big"), d, n).to_bytes((n.bit_length() + 7) // 8, 'big') for i in range(0, len(input_bytes), a)]

    print("".join([binascii.hexlify(mmm).decode('utf-8').upper().rjust(320)[::2] for mmm in m]))

testdecrypt()