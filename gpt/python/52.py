
def index_of_coincidence(text):
    # Normalize the text by removing non-alphabetic characters and converting to uppercase
    text = ''.join(filter(str.isalpha, text)).upper()
    
    # Initialize a dictionary to count occurrences of each letter
    frequency = {chr(i): 0 for i in range(ord('A'), ord('Z')+1)}
    
    # Count each letter in the text
    for letter in text:
        if letter in frequency:
            frequency[letter] += 1
    
    # Calculate the IC
    n = len(text)
    ic = sum(f * (f - 1) for f in frequency.values()) / (n * (n - 1)) if n > 1 else 0
    
    return ic

# Example usage:
text = "Your text string from the for loop goes here"
ic =
