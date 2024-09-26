import subprocess

def crack_des_unix_hash(hash_value):
    command = ['john', '--wordlist=/path/to/your/passwords.txt', f'{hash_value}']
    result = subprocess.run(command, capture_output=True)

    if 'Loaded 1 password hash' in str(result.stdout):
        return str(result.stderr).split('\\n')[0].strip()
    else:
        return None

print(crack_des_unix_hash('U5IhmemtXSSA.'))