from collections import Counter

print(hash(frozenset(Counter([1,2,1]).items())) 
print(hash(frozenset(Counter([1,1,2]).items())))
print(hash(frozenset(Counter([1,2,1]).items())) == hash(frozenset(Counter([1,2,2]).items())))