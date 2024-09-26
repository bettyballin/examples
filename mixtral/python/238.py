from scapy.all import sniff, TCP

def my_filter(pkt):
    if pkt[TCP].flags & TCP_SYN and not (pkt[TCP].flags & TCP_ACK) and not (pkt[TCP].flags & TCP_PSH):
        return True

def mitm(pkt):
    # your mitm function implementation here
    pass

sniff(iface="myinter", prn=lambda x: mitm(x) if my_filter(x) else None, count=1)