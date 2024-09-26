import subprocess

# Replace with your own file paths
private_key_path = '/path/to/myPrivKey.pem'
certificate_path = '/path/to/myCert.crt'
chain_path = '/path/to/myCertChain.crt'
output_file_path = '/path/to/output.p12'

# Run the openssl pkcs12 command
subprocess.run([
    'openssl', 'pkcs12', '-export', '-out', output_file_path,
    '-inkey', private_key_path, '-in', certificate_path,
    '-certfile', chain_path
])