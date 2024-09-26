def roll_left(s, n):
    return s[n:] + s[:n]

lc = 'abcdefghijklmnopqrstuvwxyz'
print(roll_left(lc, 13))  # Output: 'nopqrstuvwxyzabcdefghijklm'
print(roll_left(lc, 5))   # Output: 'fghijklmnopqrstuvwxyzabcde'