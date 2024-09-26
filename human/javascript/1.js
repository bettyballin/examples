var ndomain = document.domain;
var mydomain = 'www.foo.com';
var alink = document.getElementsByTagName('a');
for (var i = 0; i < alink.length; i++) {
    if (alink[i].href.length > 0){
        if (alink[i].host.substr(0, mydomain.length) == mydomain){
            var currentHref = alink[i].getAttribute('href');
            var newHref = new URL(currentHref);
            newHref.host = ndomain;
            alink[i].setAttribute('href', newHref.href);
        }
    }
}