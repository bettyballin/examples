// Call applet method
function save() {
  setTimeout(function () {
    document.myApplet.saveFile('\\\\\\\\LOCATION\\\\DIR\\\\DIR\\\\test.txt');
  }, 0);
}

// Output responses from the applet to a div
function appleMsg(response, type) {
  var output = document.getElementById("output");

  if (type === "win")
    output.style.color = "#28a745";

  else if (type === "fail")
    output.style.color = "#dc3545";

  else
    output.style.color = "";

  output.innerHTML += "<br>" + response;
}