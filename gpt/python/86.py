
   from scapy.all import IP, TCP, sr1

   target_ip = "192.168.1.1"

   # Send a TCP SYN packet
   packet = IP(dst=target_ip) / TCP(dport=80)
   response = sr1
