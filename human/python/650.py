import hashlib
import itertools
import time

match_target = bytes.fromhex('a0eebb')
alphabet = ''.join(map(chr, range(33, 127))).encode('ascii')

def find_hash_input(target: bytes) -> tuple[str, int]:
    target_len = len(target)
    iteration_count = 0
    for input_tuple in itertools.product(alphabet, repeat=6):
        input_bytes = bytearray(input_tuple)
        iteration_count += 1
        if hashlib.sha256(input_bytes).digest()[:target_len] == target:
            return input_bytes.decode('ascii'), iteration_count

def tests():
    start = time.process_time()
    input_str, count = find_hash_input(match_target)
    elapsed = time.process_time() - start
    print(f'found {input_str} in {elapsed} seconds')
    if hashlib.sha256(input_str.encode('ascii')).digest()[: len(match_target)] != match_target:
        print('failure')
    else:
        print(f'success after {count} iterations')

if __name__ == '__main__':
    tests()