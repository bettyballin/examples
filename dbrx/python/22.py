import os

def unhide_file_from_image(image_path):
    # Open modified image and read binary contents
    with open(image_path, 'rb') as img:
        data = img.read()

    # Find where our hidden content starts by looking for a null byte (0x00)
    start_index = len(data) - 1
    while True:
        if data[start_index:start_index+1] == b'\x00':
            break
        else:
            start_index -= 1

    # Extract the embedded file and write it to disk
    with open('unhidden.txt', 'wb') as f:
        f.write(data[start_index+1:])

unhide_file_from_image('image_with_hidden_data.jpg')