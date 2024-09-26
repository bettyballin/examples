from flask import Flask, render_template, redirect, url_for, request
from werkzeug.urls import url_parse
from forms import LoginForm

app = Flask(__name__)

@app.route('/login', methods=['GET', 'POST'])
def login():
    form = LoginForm()
    if form.validate_on_submit():
        next = request.args.get('next')
        if not next or url_parse(next).netloc != '':
            next = url_for('default_redirect')
        return redirect(next)
    return render_template('login.html', title="Login", form=form)

if __name__ == '__main__':
    app.run(debug=True)