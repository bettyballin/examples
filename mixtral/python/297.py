import subprocess
from dns import resolver

def get_domain_ips(domain):
    try:
        answers = resolver.query(domain, 'A')
        ips = [answer.address for answer in answers]
        return ips
    except Exception as e:
        print(f"Error: {str(e)}")
        return []

def update_iptables():
    ips = get_domain_ips('facebook.com')

    # Flush existing rules
    subprocess.run(['sudo', 'iptables', '-F'])

    for ip in ips:
        print(f"Blocking IP: {ip}")

        # Block incoming traffic from the domain's IP
        subprocess.run(
            ['sudo', 'iptables', '-A', 'INPUT',
             '-p', 'tcp',
             '--source', f"{ip}/32",
             '-j', 'DROP'])

if __name__ == "__main__":
    update_iptables()