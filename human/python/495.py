import hashlib
import numpy as np
import matplotlib.pyplot as plt

X = np.linspace(0,100,1000)
Y = np.sin(0.5*X)
plt.plot(X,Y)
plt.gcf().canvas.mpl_connect('draw_event', lambda e: None)  # Ensure canvas is drawn
plt.gcf().canvas.draw()

canvas = plt.gcf().canvas
buf = canvas.tostring_rgb()
actual_hash = hashlib.sha1(np.fromstring(buf, dtype='uint8')).hexdigest()