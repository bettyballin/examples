user_string = "Hello {name}!"
print(user_string.format(name="Homer"))  # Safe

# But if the format string contains a field name that doesn't exist in your data
# Python will raise an exception.
try:
    user_string.format()
except KeyError as e:
    print(f"KeyError: {e}")