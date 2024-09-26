import csv
import nmap

def do_scan(ip, options):
    nm = nmap.PortScanner()
    nm.scan(ip, '1-1024', options)
    return nm.get_nmap_last_output()

def print_scan(report):
    print(report)

with open('file_containing_ip_to_be_port_scanned.csv', 'r') as f:
    reader = csv.reader(f)
    ip_addresses = list(reader)

for ip in ip_addresses:
    report = do_scan(ip[0], "-sV")
    if report:
        print_scan(report)