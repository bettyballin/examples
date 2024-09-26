function createGenericThing(evt) {
    var xmlhttp = new XMLHttpRequest();

    xmlhttp.open("POST", "handlerurl", true);

    // Set the content type header
    xmlhttp.setRequestHeader('Content-Type', 'application/json');

    // Send JSON data as request body
    var jsonData = JSON.stringify({ cmd: "doSomething", data: evt });

    xmlhttp.send(jsonData);
}