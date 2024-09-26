var xhr = new XMLHttpRequest();
xhr.open("GET", "http://your-site.com/getJson", true);
xhr.setRequestHeader("Content-Type", "application/json");
xhr.onreadystatechange = function() {
    if (xhr.readyState === 4 && xhr.status === 200) {
        var json = JSON.parse(xhr.responseText);
        window.__callback__(json);
    }
};
xhr.send();