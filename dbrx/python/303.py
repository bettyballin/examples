import ast

decrypted_message = encryption_type.decrypt(original)
testing = decrypted_message.decode("utf-8")

# Parse the expression using 'ast'
tree = ast.parse(testing)

# Extract variable assignments
variables = {node.targets[0].id: node.value for node in tree.body if isinstance(node, ast.Assign)}

ip = variables['ip']
username = variables['username']
password = variables['password']

print(f"IP: {ip}")
print(f"Username: {username}")
print(f"Password: {password}")