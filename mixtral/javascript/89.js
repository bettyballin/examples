var ajax = new XMLHttpRequest();
ajax.open("POST", url, true);
ajax.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

function ONLINE_submitScore(strName, intMs){
    var params = "name=" + encodeURIComponent(strName)
                + "&score=" + Math.round(intMs);
    ajax.send(params);
}