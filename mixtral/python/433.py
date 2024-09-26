from .decorators import admin_required
from flask import app, login_required

@app.route('/students', methods=['GET', 'POST'])
@login_required
@admin_required
def students():
    pass