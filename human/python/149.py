import ast

class InjectionFinder(ast.NodeVisitor):
    def __init__(self, filename):
        self.filename = filename
        self.errors = []

    def visit_Str(self, node):
        if '%' in node.s or '.format(' in node.s:
            self.errors.append((node.lineno, "string interpolation of SQL query"))

    def report(self):
        for lineno, msg in self.errors:
            print(f"{self.filename}:{lineno}   {msg}")
        if self.errors:
            print(f"{len(self.errors)} total errors")

import sys
if __name__ == "__main__":
    if len(sys.argv) != 2:
        sys.exit(1)
    filename = sys.argv[1]
    with open(filename, 'r') as file:
        tree = ast.parse(file.read())
    finder = InjectionFinder(filename)
    finder.visit(tree)
    finder.report()