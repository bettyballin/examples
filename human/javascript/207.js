function decodeHTML(text) {
    var el = document.createElement('span');

    return el.innerHTML = text, el.textContent; 
}

console.log(decodeHTML('abc&#64;gmail&#46;com'));