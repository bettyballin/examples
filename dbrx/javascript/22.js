let CURRENT_VALUE = "test'value";
let current_value = encodeURIComponent(CURRENT_VALUE).replace(/'/g, "\\u0027");
document.getElementById("myInput").value = current_value;