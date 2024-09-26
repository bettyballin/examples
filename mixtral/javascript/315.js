var oMyObj = window.dialogArg;
var winT = oMyObj.title;

// Sanitize and encode the title
winT = DOMPurify.sanitize(winT);

document.getElementById("header").innerHTML = winT;