import os

def hide_file_in_image(image_path, file_path):
    # Open image and read data as binary
    with open(image_path, 'rb') as img:
        img_data = img.read()

    # Append hidden file to the end of the image data
    with open(file_path, 'rb') as f:
        file_data = f.read()
        new_img_data = img_data + b'\0' * (len(img_data) % 3) + file_data

    # Write modified image data back to disk
    with open(image_path, 'wb') as img:
        img.write(new_img_data)

hide_file_in_image('image.jpg', 'hidden.txt')