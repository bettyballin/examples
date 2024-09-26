
import getpass
import subprocess

password = getpass.getpass(prompt="Password: ", stream=None)

# later in a for-loop context:
for ...:
    process = subprocess.Popen(
        [command, "--cpass"],
        stdout=subprocess.PIPE,
        stderr=subprocess.PIPE,
        stdin=subprocess.PIPE,  # Enable passing data to stdin
    )
    process.communicate(input=password.encode
