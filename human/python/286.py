def hex_to_array(arr):
    return [int(n, 16) for n in arr]

def double_dabble(arr):
    l = len(arr)
    for b in range(l * 4, 0, -1):
        overflow = 0
        for i in range(len(arr) - 1, -1, -1):
            shifted = ((i < (len(arr) - l) and arr[i] > 4) and arr[i] + 3 or arr[i]) << 1
            arr[i] = (shifted & 0b1111) | overflow
            overflow = shifted > 0b1111
        if overflow:
            arr.insert(0, overflow)
    return arr[:-l]

arr = hex_to_array("8079d7")
result = double_dabble(arr)
print("".join(map(str, result)))