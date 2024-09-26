import cv2
import numpy as np

image_input = cv2.imread('image_input.jpeg', cv2.IMREAD_GRAYSCALE)
if image_input is not None:
    (x, y) = image_input.shape
    image_input = image_input.astype(float) / 255.0
else:
    print("Error: Could not read image.")