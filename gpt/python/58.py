
import subprocess

try:
    result = subprocess.run(['grep', 'regex', '/path/to/file.log'], check=True, text=True, stdout=subprocess.PIPE)
    print(result.stdout)
except subprocess.CalledProcessError as e:
    print('An error occurred:', e)
except FileNotFoundError:
    print("The file was not found.")

