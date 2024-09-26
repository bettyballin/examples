from scapy.all import sniff

def mitm(packet):
    # Your mitm function code here
    print(packet.show())

myfilter = "tcp[tcpflags] & (tcp-syn|tcp-ack|tcp-push) == tcp-syn"
sniff(iface="myinter", filter=myfilter, prn=mitm, count=1)