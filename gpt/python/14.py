
import magic

ALLOWED_MIME_TYPES = ['image/jpeg', 'image/png', 'application/pdf', 'text/html']

def file_mime_type_validator(file):
    mime = magic.from_buffer(file.read(1024), mime=True)
    file.seek(0)  # Reset file pointer after reading
    return mime in ALLOWED_MIME_TYPES

