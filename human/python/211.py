from flask import Flask, render_template
from flask_wtf import FlaskForm
from wtforms import StringField, SubmitField

app = Flask(__name__)
app.config['SECRET_KEY'] = 'mysecretkey'

class LoginForm(FlaskForm):
    email = StringField('Email')
    submit = SubmitField('Submit')

@app.route('/login', methods=['GET', 'POST'])
def login():
    login_user_form = LoginForm()
    if login_user_form.validate_on_submit():
        # handle form submission
        pass
    return render_template('login.html', login_user_form=login_user_form)

# in templates/login.html
<form method="POST">
    {{ login_user_form.hidden_tag() }}
    {{ render_field_with_errors(login_user_form.email, class_="form-control") }}
    {{ render_field(login_user_form.submit, class_="btn btn-default") }}
</form>

# in templates/macros.html
{% macro render_field_with_errors(field, class_) %}
    {{ field(class_=class_) }}
    {% if field.errors %}
        <ul class="errors">
        {% for error in field.errors %}
            <li>{{ error }}</li>
        {% endfor %}
        </ul>
    {% endif %}
{% endmacro %}

{% macro render_field(field, class_) %}
    {{ field(class_=class_) }}
{% endmacro %}