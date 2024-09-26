function getCookie(name) {
  var cookies = document.cookie.split(';');
  for(var i = 0; i < cookies.length; i++) {
    var c = cookies[i].trim();
    if (c.startsWith(name + '=')) return c.substring(name.length + 1, c.length);
  }
  return '';
}

var cookieName = 'your_cookie_name';
var cookieValue = getCookie(cookieName);
if(cookieValue) {
  // Check for Secure flag
  console.log(document.cookie.indexOf('; ' + cookieName + '=') !== -1 && document.cookie.split('; ')[0].indexOf('Secure') === 0)
}