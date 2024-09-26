import itertools

# Define the format string
format_string = "{:02d}-{:06d}"

# Calculate the total number of possible combinations
total_combinations = (10 ** 2) * (10 ** 6)

# Generate all possible combinations using itertools
combinations = itertools.product(range(10), repeat=8)

# Print each combination in the format "##-######"
for combination in combinations:
    print(format_string.format(combination[0]*10 + combination[1], combination[2]*100000 + combination[3]*10000 + combination[4]*1000 + combination[5]*100 + combination[6]*10 + combination[7]))