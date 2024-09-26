function checkBannedEmailProvider(email) {
  var re = new RegExp('\\b[\\w.!#$%&\'*+\\/=?^`{|}~-]+@(protonmail|hush)+(?:\\.[\\w-]+)*\\b');
  var OK = re.exec(email);
  if (!OK) {
     console.error(email + ' : Email provider not permitted. '); 
  } else {
     console.log(OK[0] + ' : Valid email provider. ');
  }
}

var email = 'asd@protonmail.com'
checkBannedEmailProvider(email);