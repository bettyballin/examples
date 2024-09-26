var scripts = document.getElementsByTagName("script");
SiteHostUrl = scripts[scripts.length-1].src;
jsUrl = SiteHostUrl;
console.log(jsUrl);