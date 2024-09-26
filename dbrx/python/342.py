import concurrent.futures
import hashlib
import random
import string

id = "1234"
random_string_length = 10


def hash_generator(random_string):
    return (
        ''.join(random.choice(string.ascii_letters) for _ in range(random_string_length))
        + id,
        hashlib.sha256(
            (''.join(random.choice(string.ascii_letters) for _ in range(random_string_length)))
            .encode()
        ).hexdigest()
    )


if __name__ == "__main__":
    with concurrent.futures.ThreadPoolExecutor() as executor:
        futures = {
            executor.submit(hash_generator, random_string): random_string
            for i, random_string in enumerate([''.join(random.choice(string.ascii_letters) for _ in range(random_string_length)) for i in range(1000)])
        }

        while True:
            done_futures = [future.done() for future in futures]
            if all(done_futures):
                break

    valid_hashes = [
        (random_string, hash_value) for (random_string, future), hash_value in zip(futures.items(), [future.result() for future in futures.keys()]) if (
            hash_value[1][0:6] == "a0eebb" and
            hash_value[1][6:8] == id[-2:]
        )
    ]

    print("Valid hashes:")
    for random_string, valid_hash in sorted(valid_hashes):
        print(f"{random_string}: {valid_hash[1]}")