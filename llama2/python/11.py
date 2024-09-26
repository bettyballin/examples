import hashlib
from progressbar import ProgressBar, Percentage, Bar, ETA

file = 'path_to_your_file'  # replace with your file path
f = open(file, 'rb')
m = hashlib.md5()
pbar = ProgressBar(max_value=os.path.getsize(file), widgets=[Percentage(), Bar('=') , ETA()])

while True:
    chunk = f.read(4096)
    if not chunk:
        break
    m.update(chunk)
    pbar.update(len(chunk))

checksum = m.hexdigest()
pbar.finish()
print('Checksum:', checksum)