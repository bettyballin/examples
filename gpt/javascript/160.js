
loginModel.save(loginModel.toJSON(), {
    type: 'POST',
    url: '/j_spring_security_check',
    contentType: 'application/x-www-form-urlencoded',
    data: $.param({j_username: loginModel.get('username'), j_password: loginModel.get('password')}),
    success: function(response) {
        Backbone.history.navigate('', {trigger: true});
    },
    error: function() {
        console.log('Login failed');
    }
});

