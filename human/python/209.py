import nmap

def do_scan(ip, options):
    nm = nmap.PortScanner()
    nm.scan(ip, '1-1024', options)
    return nm.get_nmap_last_output()

def print_scan(report):
    print(report)

with open('ip_list.txt') as f:
    for ip in f.read().splitlines():
        report = do_scan(ip, "-sV")
        if report:
            print_scan(report)