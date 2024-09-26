#! /usr/bin/env python

''' Unscramble a string of text by brute force

From http://stackoverflow.com/questions/26248379/influence-of-choosing-string-as-seed-of-random-on-the-output

'''

import sys
from random import seed, shuffle
from itertools import product
from string import ascii_letters


def scramble(seq, key):
    seed(key)
    msg = seq[:]
    shuffle(msg)
    return msg


def scramble_old(seq, key):
    seed(key)
    r = range(len(seq))
    shuffle(r)
    return [seq[i] for i in r]


def unscramble(seq, key):
    seed(key)
    r = range(len(seq))
    shuffle(r)
    newseq = len(seq) * [None]
    for i, j in enumerate(r):
        newseq[j] = seq[i]
    return newseq


def test():
    key = 'zap'
    #orig = 'quickbrownfox'
    orig = '01234'

    print('orig:       ', orig)
    shuf = scramble(list(orig), key)
    print('shuffled:   ', ''.join(shuf))
    unshuf = unscramble(shuf, key)
    print('unshuffled: ', ''.join(unshuf))


def decode(seq, begin):
    count = 0
    begin_len = len(begin)
    for k in product(*[ascii_letters]*3):
        key = ''.join(k)
        dup = seq[:]
        newseq = unscramble(dup, key)
        if newseq[:begin_len] == begin:
            count += 1
            print('%s: [%s] %s' % (key, ''.join(newseq), count))
            #print('     [%s]\n' % ''.join(scramble(newseq, key)))


def main():
    original_str = 'euTtSa:0 kty1h a0  nlradstara  atlot 5wtic'.lower()    
    original_list = list(original_str)
    print('     [%s], %d\n' % (original_str, len(original_str)))

    decode(original_list, begin=list('the'))


if __name__ == '__main__':
    #test()
    main()