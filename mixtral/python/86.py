import os
from dotenv import load_dotenv

load_dotenv()

ALLOWED_HOSTS = [os.getenv('DJANGO_ALLOWED_HOSTS')]

# or if you have multiple domains

if os.getenv('DJANGO_ALLOWED_HOSTS') is not None:
    allowed_hosts = []
    for domain in os.getenv('DJANGO_ALLOWED_HOSTS').split():
        allowed_hosts.append(domain)

    ALLOWED_HOSTS = allowed_hosts