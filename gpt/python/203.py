
from flask_login import current_user
from flask_admin.contrib.sqla import ModelView
from sqlalchemy import func

class UserView(ModelView):
    # ...

    def is_accessible(self):
        # You should also override this method to prevent unauthorized access
        return current_user.is_authenticated and (current_user.is_admin or ...)
    
    def get_query(self):
        if current_user.is_admin:  # Assuming `is_admin` is a property that defines an admin
            return self.session.query(self.model)
        else:
            return self.session
