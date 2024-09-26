function urlToFile(dataUrl, filename, mimeType) {
    return fetch(dataUrl)
        .then(res => res.arrayBuffer())
        .then(buf => new File([buf], filename, { type: mimeType }));
}