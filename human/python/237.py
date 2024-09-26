from wtforms import Form, TextField, ValidationError

class AccountSettingsForm(Form):
    password_proof = TextField("Password:")

    def __init__(self, user, *args, **kwargs):
        super(AccountSettingsForm, self).__init__(*args, **kwargs)
        self.user = user

    def validate_password_proof(self, field):
        if field.data != self.user.password:
            raise ValidationError('Wrong password.')

if __name__ == "__main__":
    class User:
        def __init__(self, password):
            self.password = password

    user = User("test_password")
    form = AccountSettingsForm(user)
    form.password_proof.data = "wrong_password"
    try:
        form.validate()
    except ValidationError as e:
        print(e)