block_size = 245
f = "your_string_here"  # replace with your actual string
blocks = [f[i : i + block_size] for i in range(0, len(f), block_size)]