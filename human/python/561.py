import numpy as np
from PIL import Image

# Load the input image
image_input = np.array(Image.open('image_input.jpg')) / 255.0

# Set the dimensions of the key
x, y = image_input.shape[:2]

mu, sigma = 0, 0.1 # mean and standard deviation
key = np.random.normal(mu, sigma, (x, y)) + np.finfo(float).eps

image_encrypted = image_input / key[:, :, np.newaxis]

import cv2
cv2.imwrite('image_encrypted.jpg', (image_encrypted * 255).astype(np.uint8))