import string

s1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
s2 = "XPMGTDHLYONZBWEARKJUFSCIQV"
trans = str.maketrans(s1, s2)
strtrans = "THIS IS A SAMPLE PROGRAM FOR MAKETRANS"
outstr = strtrans.translate(trans)
print(outstr)