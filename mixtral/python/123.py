with open('input.txt', 'r') as f:
    lines = [line.rstrip('\n') for line in f]

counter = 0
out_filename1 = 'output'
counter += 1
out_filename = out_filename1 + '.' + lines[counter-1].strip()