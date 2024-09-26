import subprocess

subprocess.run(['./configure.sh'], check=True)
subprocess.run(['sudo', 'make'], check=True)
subprocess.run(['sudo', 'make', 'install'], check=True)
subprocess.run(['sudo', 'ldconfig'], check=True)