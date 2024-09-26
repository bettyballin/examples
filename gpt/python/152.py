
from libnmap.process import NmapProcess

def do_scan(targets, options):
    nmproc = NmapProcess(targets, options)
    rc = nmproc.run()
    if rc != 0:
        print("nmap scan failed: {0}".format(nmproc.stderr))
        return None
    return nmproc.stdout

def print_scan(report):
    print("Scan Output:\n")
    print(report)

if __name__ == "__main__":
    # Open the file containing the IP addresses
    with open('file_containg_ip_to_be_port_scanned', 'r') as file_object:
        for line in file_object:
            ip_address = line.strip()  # Remove any leading/trailing whitespace
            report = do_scan(ip_address, "-sV")
            if report:
                print_scan(report)

