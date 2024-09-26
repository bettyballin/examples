import py_compile

try:
    py_compile.compile("the_greatest_script.py")
except py_compile.PyCompileError as e:
    print(f"Error compiling file: {e}")
else:
    print("Compilation successful")