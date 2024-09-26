
ALLOWED_EXTENSIONS = ['jpg', 'jpeg', 'png', 'pdf', 'html']

def file_extension_validator(filename):
    return '.' in filename and filename.rsplit('.', 1)[1].lower() in ALLOWED_EXTENSIONS

