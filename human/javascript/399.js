var location = { pathname: "/path/to/page" };
var form_data = "key=value&foo=bar";

var pageUrl = location.pathname.split('/').pop() + '?' + form_data;

console.log(pageUrl);