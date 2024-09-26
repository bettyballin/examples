from string import maketrans 

alphabet = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
reversed_alphabet = alphabet[::-1]

table = maketrans(alphabet, reversed_alphabet)  

print('CBA'.translate(table))