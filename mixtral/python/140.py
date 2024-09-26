import subprocess
import os
import pickle

def send_and_receive(data):
    # Create two unnamed pipes
    read_pipe, write_pipe = os.pipe()

    process = subprocess.Popen(['foo2.py'], stdin=subprocess.PIPE)

    # Send data to foo2
    with os.fdopen(write_pipe, 'wb') as f:
        pickle.dump((data,), f)

    os.close(write_pipe)

    process.stdin.flush()

    output = []

    while True:
        line = read_from_process(read_pipe).decode('utf-8')

        if not line or 'END' in line:
            break

        output.append(line)

    os.close(read_pipe)

    return '\n'.join(output)

def read_from_process(fd):
    try:
        data = b''

        while True:
            chunk = os.read(fd, 1024).strip()

            if not chunk or 'END' in str(chunk, 'utf-8'):
                break

            data += chunk

        return data
    except Exception as e:
        print('Error reading from process', e)

# Usage
data = "Sensitive information"
result = send_and_receive(data)
print(result)