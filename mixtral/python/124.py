with open('extensions.txt', 'r') as f:
    lines = [line.rstrip('\n') for line in f]

for counter, in_filename in enumerate(files):
    ....

    with open(in_filename, 'rb') as in_file, \
         open(out_filename, 'wb') as out_file:
        decrypt(in_file, out_file, password)