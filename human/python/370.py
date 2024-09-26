import csv

key = 49

with open('keys.csv', 'w+', newline='') as f:
    headers = ['key']
    writer = csv.DictWriter(f, fieldnames=headers)
    writer.writeheader()
    writer.writerow({'key': key})