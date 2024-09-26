def euclid(a, b):
    '''Solve x*a + y*b = ggt(a, b) and return (x, y, ggt(a, b))'''
    # Non-recursive approach hence suitable for large numbers
    x = yy = 0
    y = xx = 1
    while b:
        q = a // b
        a, b = b, a % b
        x, xx = xx - q * x, x
        y, yy = yy - q * y, y
    return xx, yy, a

def inv(a, n):
    '''Perform inversion 1/a modulo n. a and n should be COPRIME.'''
    # coprimality is not checked here in favour of performance
    i = euclid(a, n)[0]
    while i < 0:
        i += n
    return i

def add(a,p,P,Q):
   #Check For Neutral Element
   if P == (0,0) or Q == (0,0):
       return (P[0]+Q[0],P[1]+Q[1])

   #Check For Inverses (Return Neutral Element - Point At Infinity)
   if P[0] == Q[0]:
       if (-P[1])%p == Q[1] or (-Q[1])%p == P[1]:
           return (0,0)

   #Calculate Slope 
   if P != Q:

       # perform multiplication with the inverse modulo p
       s = (Q[1]-P[1]) * inv((Q[0]-P[0])%p, p)
   else:
       s = ((3*(P[0]*P[0])+a)%p) * inv((2*P[1])%p, p)

   #Calculate Third Intersection
   x = (s*s - P[0] - Q[0])%p
   y = (s*(P[0]-x) - P[1])%p

   return (x,y)

r = (5,1)
for i in range(1,20):
   print(i,':',r)
   r = add(2,17,r,(5,1))