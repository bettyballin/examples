from flask import request, jsonify
from flask_security import login_user, _commit
from flask_security.forms import LoginForm
from flask_wtf import Form
from werkzeug.datastructures import MultiDict

@anonymous_user_required
def api_login():
    """View function for login view"""

    form_class = LoginForm

    if request.is_json:
        form = form_class(MultiDict(request.get_json()))
        if form.validate_on_submit():
            login_user(form.user, remember=form.remember.data)
            after_this_request(_commit)
            return _render_json(form, include_auth_token=True)
    return jsonify(*get_message('INVALID_LOGIN_ATTEMPT'))