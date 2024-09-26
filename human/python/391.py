with open('afile.txt', 'w') as fh:
    for i in range(2):
        fh.write('%s\n'%b'hi there')

with open('afile.txt', 'rb') as fh:
    for line in fh:
        print(line.decode())