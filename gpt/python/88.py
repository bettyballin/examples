
from werkzeug.utils import secure_filename

# Sanitize the filename
safe_filename = secure_filename(filename)

# Use the safe filename
