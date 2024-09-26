
from scapy.all import sniff, TCP

def mitm(packet):
    if TCP in packet:
       
