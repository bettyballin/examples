import numpy as np
from cv2 import imwrite

# assuming image_encrypted and key are numpy arrays
image_encrypted = np.random.rand(512, 512)  # replace with actual encrypted image
key = np.random.rand(512, 512)  # replace with actual key

image_output = image_encrypted * key
image_output *= 255.0
image_output = np.uint8(image_output)  # convert to uint8 before saving

imwrite('image_output.jpg', image_output)