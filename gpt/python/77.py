
def hide_file_in_image(img_filename, file_to_hide, output_filename):
    with open(img_filename, 'rb') as img_file:  # Open the image file in binary read mode
        img_data = img_file.read()
    with open(file_to_hide, 'rb') as hidden_file:  # Open the file to hide in binary read mode
        hidden_data = hidden_file.read()
    
    with open(output_filename, 'wb') as output_file:  # Open the output file in binary write mode
        output_file.write(img_data)  # Write the image data to the output file
        output_file.write(hidden_data)  # Append the hidden file's data to the output file

# To hide a file
hide_file_in_image('image.png', 'file_to_hide.zip', 'output_img_with_hidden_file.png')

def extract_hidden_file_from_image(img_with
