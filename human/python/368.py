import csv

with open("Keys.txt", "w+", newline='') as csvfile:
    headers = ['key']
    writer=csv.DictWriter(csvfile, fieldnames=headers)
    writer.writeheader()
    writer.writerow({'key': 'jDyzNLo3aPD6-zFGVRnzMyBdyy93wQhemJ8QR4VH2I0='})