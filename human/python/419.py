import string

def roll_left(s, n):
    return s[n:] + s[:n]

lc = string.ascii_lowercase
tinv5 = str.maketrans(roll_left(lc, 5), lc)

print('ymnx nx f yjxy'.translate(tinv5))