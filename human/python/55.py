import re

filename = 'example.txt'  # replace with your file name
regex = 'pattern'  # replace with your regular expression

with open(filename, 'r') as f:
    for line in f:
        if re.search(regex, line):
            print(line)