from flask import current_user
from flask_admin.contrib.sqla import ModelView
from sqlalchemy import func

class UserView(ModelView):
    def get_query(self):
        if not hasattr(current_user, 'is_admin') or not current_user.is_admin:
            return self.session.query(self.model).filter(self.model.id == current_user.id)

        # If the user is an admin
        else:
            return super().get_query()

    def get_count_query(self):
        if not hasattr(current_user, 'is_admin') or not current_user.is_admin:
            return self.session.query(func.count('*')).select_from(self.model).filter(self.model.id == current_user.id)

        # If the user is an admin
        else:
            return super().get_count_query()