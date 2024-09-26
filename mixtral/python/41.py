from scapy.all import *

def PacketHandler(pkt):
    if pkt.haslayer(Dot11) and (pkt.type == 2 or pkt.subtype in [4]):
        # Data packet
        print("Source MAC: {} Destination MAC: {}".format(pkt.addr2, pkt.addr3))

        if pkt.haslayer(IP):
            ip = pkt.getlayer(IP)
            print("\tProtocol: IP")
            # Print source and destination addresses
            print("Source Address: {} Destination Address: {}".format(ip.src, ip.dst))

        elif pkt.haslayer(ARP):
            arp = pkt.getlayer(ARP)
            if arp.op == 1 or arp.op == 2:
                print("\tProtocol: ARP")
                # Print sender and target addresses
                print("Sender Address: {} Target Address: {}".format(arp.psrc, arp.pdst))

        elif pkt.haslayer(DNS):
            dns = pkt.getlayer(DNS)
            if len(dns.qd) > 0 and (dns.opcode == 0 or dns.rcode == 0):
                print("\tProtocol: DNS")

        elif pkt.haslayer(TCP):
            tcp = pkt.getlayer(TCP)
            if len(tcp) > 128:
                # Print source and destination ports
                print("Source Port: {} Destination Port: {}".format(tcp.sport, tcp.dport))

        elif pkt.haslayer(UDP):
            udp = pkt.getlayer(UDP)
            if len(udp) > 128:
                # Print source and destination ports
                print("Source Port: {} Destination Port: {}".format(udp.sport, udp.dport))

sniff(prn=PacketHandler)