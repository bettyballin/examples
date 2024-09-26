
import io
import hashlib
import numpy as np
import matplotlib.pyplot as plt

# Create a figure
X = np.linspace(0, 100, 1000)
Y = np.sin(0.5 * X)
plt.plot(X, Y)
fig = plt.gcf()

# Convert the figure to PNG format in memory
buf = io.BytesIO()
fig.savefig(buf, format='png')

# Get the PNG buffer bytes and calculate the hash
buf.seek(0)  # Important: return to the start of the BytesIO buffer!
hash_value = hashlib.sha1(buf.getvalue()).hexdigest()

# Now you can use hash_value to compare with expected hash
expected_hash = 'the_expected_hash_value'
assert hash_value == expected_hash

