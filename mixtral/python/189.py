def XORfunc(input_1, input_2):
    bin_input_1 = hexToBinary(input_1)
    bin_input_2 = hexToBinary(input_2)

    # check if length of strings is the same for XOR compare or add "0" to the end
    if len(bin_input_1) != len(bin_input_2):
        number_length = max([len(bin_input_1), len(bin_input_2)])

        bin_input_1, bin_input_2 = [s.zfill(number_length) for s in (bin_input_1, bin_input_2)]

    solution = []

    # XOR is like a sum so if el1+el2 == 1 output is 1 else output is 0
    for x in range(len(bin_input_1)):
        current_compare = int(bin_input_1[x]) ^ int(bin_input_2[x])

        solution.append('1' if current_compare == 1 else '0')

    return decToHex(int("".join(solution), 2))

def hexToBinary(text):
    # first Hex is converted to decimal then to binary (that needs to be sliced for a clean output)
    return bin(int(text, 16))[2:]

def decToHex(text):
    return hex(text)[2:]

# Test the function
print(XORfunc("A", "B"))