with open("out.jpg", "wb") as out:
    with open("someimage.jpg", "rb") as image:
        out.write(image.read())
    with open("somehiddenfile.pdf", "rb") as hidden_file:
        out.write(hidden_file.read())