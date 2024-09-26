import hashlib
import socket

def get_machine_id():
    # Get the computer's hostname
    hostname = socket.gethostname()

    # Generate a hash of the hostname and some other identifying information
    hash = hashlib.sha256(hostname.encode('utf-8')).hexdigest()

    return hash

if __name__ == "__main__":
    machine_id = get_machine_id()
    print(f"Machine ID: {machine_id}")