import csv

key = b'some_key'  # replace with your key

with open('keys.csv', 'w+', newline='') as f:
    headers = ['key']
    writer = csv.DictWriter(f, fieldnames=headers)
    writer.writeheader()
    writer.writerow({'key': key.decode('utf-8')})