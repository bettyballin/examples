import io
import matplotlib.pyplot as plt
import hashlib

# Create a simple plot
fig, ax = plt.subplots()
ax.plot([1, 2, 3])

buffer = io.BytesIO()
fig.savefig(buffer, format='png')
buffer.seek(0)

actual_hash = hashlib.sha1(buffer.getvalue()).hexdigest()

expected_hash = 'your-precomputed-hash'  # replace with your actual hash
assert actual_hash == expected_hash