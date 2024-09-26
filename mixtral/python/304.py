mask = [[0, 0, 0, 0, 0, 1, 0, 0],
        [0, 0, 0, 0, 1, 0, 0, 0],
        [0, 0, 0, 1, 0, 0, 0, 0],
        [0, 0, 1, 0, 0, 0, 0, 0],
        [0, 1, 0, 0, 0, 0, 0, 0],
        [1, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0]]

input_pixel = [[1, 2, 3, 4, 5, 6, 7, 8],
               [9, 10, 11, 12, 13, 14, 15, 16],
               [17, 18, 19, 20, 21, 22, 23, 24],
               [25, 26, 27, 28, 29, 30, 31, 32],
               [33, 34, 35, 36, 37, 38, 39, 40],
               [41, 42, 43, 44, 45, 46, 47, 48],
               [49, 50, 51, 52, 53, 54, 55, 56],
               [57, 58, 59, 60, 61, 62, 63, 64]]

for row_idx in range(len(input_pixel)):
    temp1 = []
    temp2 = []

    for bit_idx in range(len(input_pixel[row_idx])):
        if mask[row_idx][bit_idx]:
            # 'Case B'
            temp2.append(input_pixel[row_idx][bit_idx])

        else:
           # 'Case A'
            temp1.append(input_pixel[row_idx][bit_idx])

    print("Row:", row_idx)
    print("Temp1:", temp1)
    print("Temp2:", temp2)