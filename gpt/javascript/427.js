
// Function to convert data to a WordArray
function fileToWordArray(file, callback) {
    const reader = new FileReader();
    reader.onload = function () {
        const wordArray = CryptoJS.lib.WordArray.create(reader.result);
        callback(wordArray);
    };
    reader.readAsArrayBuffer(file);
}

// Function to save WordArray to file
