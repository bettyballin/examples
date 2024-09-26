
myfilter = 'tcp[tcpflags] & (tcp-syn|tcp-ack) == tcp-syn and tcp[tcpflags] & tcp-psh == 0'

