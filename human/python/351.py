import sys

def check():
   if sys.version_info[0] == 2:
      from itertools import izip
   else:
      izip = zip

   a=[1,2,3]
   b=[4,5,6]

   print(izip)
   for c in izip(a,b):
       print(c)

check()