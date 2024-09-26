import web

def validate_input(data):
    # Perform basic validation e.g check for empty strings or invalid characters.
    if not data:
        return False
    if not isinstance(data, str):
        return False
    if any(not c.isalnum() and not c.isspace() for c in data):
        return False
    return True

# In your POST method
form = web.input(quest_title="", quest_difficulty="", quest_post="")
if not all(validate_input(getattr(form, attr)) for attr in ["quest_title", "quest_difficulty", "quest_post"]):
    print("Invalid input data")
else:
    print("Input data is valid")