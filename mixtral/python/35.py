from scapy.all import sniff, IP, SMB, Raw

def disp(pkt):
    print(pkt.getlayer(IP).src)

    # Check if packet contains SMB layer
    if pkt.haslayer(SMB):
        smb_packet = pkt[SMB]

        # Check for Session Setup AndX Request
        if hasattr(smb_packet, 'SessionSetupAndX'):
            session_setup = SMBSession_Setup_AndX_Request(pkt.getlayer(Raw).load)

            print("Native OS:", session_setup['NativeOS'])

foo = sniff(prn=disp, filter="port 445", count=10)