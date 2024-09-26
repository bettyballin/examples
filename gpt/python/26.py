
safe_globals = {
    '__builtins__': {},  # Start with an empty set of built-ins
    'allowed_function': some_function,  # Explicitly add functions you want to expose
    # ... other safe functions and variables
}

# Potentially add some safe built-in functions
safe_globals['__builtins__']['len'] = len
# ... and so on, for each built-in function you want to allow

exec(code, safe_globals)

