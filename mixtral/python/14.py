with open('imagefile', 'rb') as img_f, \
     open('hiddenfile', 'rb') as txt_f, \
     open('newfile.jpg', 'wb') as out_f:
    data = img_f.read() + txt_f.read()
    out_f.write(data)