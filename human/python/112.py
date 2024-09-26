#!/usr/bin/env python

from scapy.all import *

def packet_handler(pkt) :
    # if packet has 802.11 layer, and type of packet is Data frame
    if pkt.haslayer(Dot11) and pkt.type == 2:
            # do your stuff here
            print(pkt.show())

if __name__ == "__main__":
    sniff(iface="mon0", prn=packet_handler)