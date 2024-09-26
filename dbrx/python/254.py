import pickle
import hashlib
import matplotlib.pyplot as plt

# Create a simple plot
fig, ax = plt.subplots()
ax.plot([1, 2, 3, 4])
ax.set_title('Simple Plot')

# Pickle the figure
fig_data = pickle.dumps(fig)

# Calculate the hash
actual_hash = hashlib.sha1(fig_data).hexdigest()

print(actual_hash)