var xhr = new XMLHttpRequest();
xhr.onload = function() {
    var json = xhr.responseText.replace(/^[^\{]+/, '').replace(/\);?$/, '');
    json = JSON.parse(json);
    // Example, alert latitude and longitude
    alert(json.geoplugin_latitude + ', ' + json.geoplugin_longitude);
};
xhr.open('GET', 'https://proxy.cors.sh/http://www.geoplugin.net/json.gp');
xhr.send();