import nmap

def do_scan(ip):
    nm = nmap.PortScanner()
    nm.scan(ip, '1-1024', '-sV')
    return nm.get_nmap_last_output()

def print_scan(report):
    print(report)

def main():
    file_containing_ip_to_be_port_scanned = 'ips.txt'
    with open(file_containing_ip_to_be_port_scanned, 'r') as file:
        for ip in file:
            report = do_scan(ip.strip())
            if report:
                print_scan(report)

if __name__ == "__main__":
    main()