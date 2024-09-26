loginModel.save({
  j_username: 'your-user',
  j_password: 'your-pass'
}, {
  url: '/j_spring_security_check',
  type: 'POST',
  success: function(response) {},
  error: function() {}
});