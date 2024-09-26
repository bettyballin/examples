import os

# Define the environment variable names
IP_ADDRESSES = 'SCAN_IP_ADDRS'
SCAN_PARAMS = 'SCAN_PARAMS'

# Check if the environment variables are set
if not os.getenv(IP_ADDRESSES) or not os.getenv(SCAN_PARAMS):
    print("Error: Environment variables SCAN_IP_ADDRS and/or SCAN_PARAMS are not set.")
    exit(1)

# Get the IP addresses and scan parameters from environment variables
ip_addrs = os.getenv(IP_ADDRESSES).split(',')
scan_params = os.getenv(SCAN_PARAMS).split(',')

# Print the IP addresses and scan parameters
print("IP Addresses:", ip_addrs)
print("Scan Parameters:", scan_params)

# Example usage:
if __name__ == "__main__":
    # Set environment variables for testing purposes
    os.environ[IP_ADDRESSES] = "192.168.1.1,192.168.1.2"
    os.environ[SCAN_PARAMS] = "param1,param2"

    # Run the script
    print("Running script...")


bash
#!/bin/bash

# Set environment variables
export SCAN_IP_ADDRS="192.168.1.1,192.168.1.2"
export SCAN_PARAMS="param1,param2"

# Run the Python script
python script.py