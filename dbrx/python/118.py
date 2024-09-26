import struct
import binascii

def multiplicative_inverse(e, phi):
    def extended_gcd(a, b):
        if a == 0:
            return b, 0, 1
        else:
            gcd, x, y = extended_gcd(b % a, a)
            return gcd, y - (b // a) * x, x

    gcd, x, y = extended_gcd(e, phi)
    if gcd != 1:
        return None
    else:
        return x % phi

def testdecrypt():
    a = 16
    e = 65537
    p = 15308793451280999927
    n = 225614505179301198794693425143200819953
    q = 14737575883906276439
    phi = (p-1)*(q-1)
    d = multiplicative_inverse(e, phi)

    with open('test.enc', 'rb') as file:
        input = binascii.hexlify(file.read())
        m = [hex(pow(int(input[i:i+a], 16), d, n)).rstrip("L") for i in range(0, len(input), a)]

    decrypted_data = b''
    for mm in m:
        num = int(mm.strip('0x'), 16)
        packed_num = struct.pack('>Q', num)
        decrypted_data += packed_num

    print(decrypted_data.decode())

testdecrypt()