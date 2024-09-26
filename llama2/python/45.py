from scapy.all import *

def PacketHandler(pkt) :
    if pkt.haslayer(Dot11) and pkt.subtype in (0, 5):
        if pkt.haslayer(IP) :
            ip=pkt.getlayer(IP)
            print(ip.dst)

        if pkt.haslayer(UDP):
            udp=pkt.getlayer(UDP)
            print(udp.dport)

        if pkt.haslayer(TCP) :
            tcp=pkt.getlayer(TCP)
            print(tcp.dport)

sniff(iface="mon0", prn=PacketHandler)