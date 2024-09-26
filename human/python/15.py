safe_functions = {
    'abs': abs,
    'all': all,
    'any': any,
    'chr': chr,
    'dir': dir,
    'divmod': divmod,
    'enumerate': enumerate,
    'filter': filter,
    'hash': hash,
    'hex': hex,
    'id': id,
    'len': len,
    'max': max,
    'min': min,
    'oct': oct,
    'ord': ord,
    'pow': pow,
    'range': range,
    'repr': repr,
    'reversed': reversed,
    'round': round,
    'slice': slice,
    'sorted': sorted,
    'sum': sum,
    'tuple': tuple,
    'type': type,
    'zip': zip
}

code = "print(abs(-10))"
eval(code, {"__builtins__": None}, safe_functions)