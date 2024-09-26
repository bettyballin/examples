from collections import Counter

x = "hire hire hire me me me bla bla bla python is fun programming x"
y = Counter(x.replace(" ", ""))
print(y)