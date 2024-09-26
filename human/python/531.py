def cut_in_columns(text, k):
    """
    Cut text in k columns
    """
    columns = [[] for _ in range(k)]

    for i, char in enumerate(text):
        columns[i % k].append(char)

    return columns

# Example usage:
text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
k = 3
result = cut_in_columns(text, k)
for i, column in enumerate(result):
    print(f"Column {i+1}: {''.join(column)}")