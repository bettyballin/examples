def LetterFrequency():
    freq = {}
    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc accumsan sem ut ligula scelerisque sollicitudin. Ut at sagittis augue. Praesent quis rhoncus justo. Aliquam erat volutpat. Donec sit amet felis quis est ullamcorper placerat. Proin blandit eu arcu eu facilisis. In hac habitasse platea dictumst. Cras et ante eget leo tempor porttitor. Vivamus bibendum tempus nisi, sed euismod ex blandit non. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Suspendisse potenti. Integer posuere erat a ante venenatis dapibus posuere velit aliquet."
    for char in text.upper():
        if char.isalpha():
            if char in freq:
                freq[char] += 1
            else:
                freq[char] = 1
    return freq

frequencies = LetterFrequency()
sorted_freq = dict(sorted(frequencies.items(), key=lambda item: item[1], reverse=True))
print(sorted_freq)

def get_every_nth_letter(text, n):
    return ''.join([char for i, char in enumerate(text.upper()) if (i+1) % n == 0])

cipher = "THISISARATHERBORINGMESSAGE"
print(get_every_nth_letter(cipher, 3))