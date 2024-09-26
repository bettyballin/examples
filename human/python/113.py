#!/usr/bin/env python3

from scapy.all import *

def packet_handler(pkt) :
    # if packet has 802.11 layer
    if pkt.haslayer(Dot11):
        # do your stuff here
        print(pkt.show())

if __name__ == "__main__":
    sniff(iface="mon0", prn=packet_handler, filter="type Data")