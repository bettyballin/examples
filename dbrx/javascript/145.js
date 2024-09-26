function urltoFile(url, filename, mimeType) {
  return fetch(url)
    .then(res => res.arrayBuffer())
    .then(buf => new File([buf], filename, { type: mimeType }));
}

urltoFile('data:image/jpg;base64', 'test.jpg', 'image/jpeg')
  .then(file => console.log(file));