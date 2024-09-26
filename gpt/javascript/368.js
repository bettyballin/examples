
function downloadFile(filename, data, mimeType) {
    let blobData = (typeof data === 'string') ? new Blob([data], { type: mimeType }) : data;
    let url = window.URL.createObjectURL(blobData);
    let element = document.createElement('a');
    element.setAttribute('href', url);
    element.setAttribute('download', filename);
    document.body.appendChild(element); // Append to the document because Firefox requires the element to be in the DOM to work
    element.click();
    document.body.removeChild(element); // Clean up
    window.URL.revokeObjectURL(url); // Free up memory
}

