from flask import redirect, url_for, flash
from flask_security import current_user, login_user, logout_user, anonymous_user_required
from flask_security.decorators import _get_token_status, _commit, _security
from flask_security.forms import ResetPasswordForm
from flask_security.utils import get_url, do_flash, get_message, update_password

@app.route('/reset/<token>')
@anonymous_user_required
def reset_password(token):
    expired, invalid, user = _get_token_status(token)
    if invalid or expired:
        do_flash(*get_message('INVALID_RESET_TOKEN'))
        return redirect(url_for('login'))

    form = ResetPasswordForm()
    if form.validate_on_submit():
        after_this_request(_commit)
        update_password(user, form.password.data)
        do_flash(*get_message('PASSWORD_RESET'))
        return redirect(get_url(_security.post_reset_view) or
                        get_url(_security.post_login_view))

    return render_template('security/reset_password.html', form=form, token=token)