
from flask import flash
from flask_login import current_user, login_required

# Assuming `isUser` attribute is a boolean indicating if the user is a regular user
# and `is_admin` is a property or method that returns True if the user is an admin.

class User(db.Model, UserMixin):
    # ... your existing fields ...
    isUser = db.Column(db.Boolean, default=False)  # Assuming this is a boolean
    
    @property
    def is_admin(self):
        return not self.isUser  # Assuming admin if not a regular user

@app.route('/addMovie/', methods=['GET', 'POST'])
@login_required
def addMovie():
    if not current_user.is_admin:
        flash('
