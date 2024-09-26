
from scapy.all import *

def packet_handler(pkt):
    # Check if the packet has the Dot11 (802.11 Wireless) layer
    if pkt.haslayer(Dot11):
        # Check if the type is Data frame (type=2) and not a management or control frame
        if pkt.type == 2:
            # Process IP, UDP, and
