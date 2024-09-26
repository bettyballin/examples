import paramiko
import warnings

warnings.filterwarnings("ignore", category=paramiko.util.CryptographyDeprecationWarning)

# Establish a connection to a remote server
ssh = paramiko.SSHClient()
ssh.set_missing_host_key_policy(paramiko.AutoAddPolicy())

# Set the hostname, username, and password
hostname = 'example.com'
username = 'your_username'
password = 'your_password'

# Connect to the remote server
ssh.connect(hostname=hostname, username=username, password=password)

# Execute a command on the remote server
stdin, stdout, stderr = ssh.exec_command('ls -l')

# Print the output
print(stdout.read().decode())

# Close the connection
ssh.close()