loginModel.save(null, {
  url: '/j_spring_security_check',
  data: $.param({ j_username: 'your-username', j_password: '<PASSWORD>' }),
  contentType: 'application/x-www-form-urlencoded; charset=UTF-8'
});