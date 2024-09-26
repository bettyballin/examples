import dns.resolver
import subprocess

# Define the domain to block
domain = 'facebook.com'

# Perform a DNS lookup for the domain
response = dns.resolver.query(domain, 'A')

# Get the IP addresses associated with the domain
ips = [rdata.to_text() for answer in response.response.answer for rdata in answer]

# Block the IP addresses using iptables
for ip in ips:
    print(f'Blocking IP {ip}')
    subprocess.run(['iptables', '-A', 'INPUT', '-s', ip, '-j', 'DROP'])