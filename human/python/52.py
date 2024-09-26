def mask_code(python_code):
    s = "+".join(["chr(" + str(ord(i)) + ")" for i in python_code])
    return "eval(" + s + ")"

bad_code = '''__import__("os").getcwd()'''
masked = mask_code(bad_code)
print(masked)
print(eval(masked))