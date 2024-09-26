import subprocess
import os

def passtofd12(password):
    def _passtofd12():
        fd = os.open('/dev/fd/12', os.O_WRONLY)
        os.write(fd, password.encode())
        os.close(fd)
    return _passtofd12

password = 'your_password_here'
subprocess.Popen(['openssl', 'enc', '-aes-256-cbc', '-pass', 'file:/dev/fd/12', '-in', 'input_file', '-out', 'output_file'],
                 preexec_fn=passtofd12(password))