function decode(input) {
    let components = input.split("-");
    let output = "";
    for (let component of components) {
        if (component.length == 0) {
            continue;
        }
        let charValue = parseInt(component);
        output += String.fromCharCode(charValue + ('a'.charCodeAt(0) - 1));
    }
    return output;
}

console.log(decode("1-2-3-4-5"));  // Output: "abcde"