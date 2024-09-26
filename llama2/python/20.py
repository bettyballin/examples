import re

# Open the file and read its contents
with open('file.txt', 'r') as file:
    contents = file.read()

# Use regular expression to find pattern in the contents
pattern = re.compile(r'your_pattern_here')
matches = pattern.findall(contents)

# Print the matches
for match in matches:
    print(match)