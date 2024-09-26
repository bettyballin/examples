import csv
from cryptography.fernet import Fernet

with open('keys.csv') as f:
    reader = csv.reader(f)
    next(reader)      # skip the header row
    for row in reader:
        csv_key = row[0]
        print(Fernet(csv_key))