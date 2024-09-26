
import os

def block_domain(domain):
    with open('/etc/hosts', 'a') as file:
        file.write(f'127.0.0.1 {domain}\n')

block_domain('facebook.com')

