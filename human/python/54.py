import string

vals = string.ascii_letters

def spy_code(txt, n):
    result = ''
    for i in txt:
        if i in vals:
            c = ord(i) + n
            if ord(i) != c:
                if i.isupper() and c > ord('Z'):
                    c -= 26
                elif i.islower() and c > ord('z'):
                    c -= 26
                b = chr(c)
                result += b
        else:
            result += i
    print(result)

spy_code('abord mission, dont atk teacher!', 5)