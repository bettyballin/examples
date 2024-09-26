
from flask_security import Security

# Assuming you have something like this in your main app setup:
security = Security(app, datastore)

# Now you can use 'security' to access the datastore

