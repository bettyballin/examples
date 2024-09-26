from flask import render_template
from flask_security.decorators import login_required, roles_required

@app.route('/register/')
@login_required
@roles_required('superuser')
def my_custom_registration():
    # Your custom registration logic here
    return render_template("security/my_custom_register.html")