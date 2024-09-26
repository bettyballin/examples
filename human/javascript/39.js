function encodeHTML(s) {
    return s.replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/"/g, '&quot;');
}

let name = "John Doe";
let somediv = document.getElementById("somediv");

somediv.innerHTML= '<p>Hello, '+encodeHTML(name)+'</p>';