import subprocess

# Set the working directory and environment variables
cwd = '/path/to/directory/containing/file.log'
env = {'PATH': '/usr/bin'}

# Run the grep command
try:
    subprocess.run(['grep', 'regex', cwd + '/file.log'], env=env, check=True)
except subprocess.CalledProcessError as e:
    print(f"Error: {e}")
except FileNotFoundError:
    print("Error: The 'grep' command was not found.")