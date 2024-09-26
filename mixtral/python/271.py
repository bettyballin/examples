def reverse_n(s, n):
    return ''.join([s[i*n : (i+1)*n][::-1] for i in range((len(s) + n - 1) // n )])

# Usage
c = [1, 2, 3, 4, 5]
binary_string = reverse_n('0b' + "".join('{:08b}'.format(byte) for byte in c), 8)
print(binary_string)