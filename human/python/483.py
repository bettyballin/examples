"""
Firestore security rules in Python (executable simulation)
"""

def evaluate_match(document):
    return {
        "read": False,
        "write": False,
    }

# Example usage:
document = {}  # Replace with actual document data
result = evaluate_match(document)
print(result)