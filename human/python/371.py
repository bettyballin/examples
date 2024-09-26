import csv
import base64

def read_keys(filename):
    with open(filename, 'r') as f:
        reader = csv.DictReader(f)
        for row in reader:
            key = base64.b64decode(row['key'].encode('utf-8'))
            print(key)

read_keys('keys.csv')