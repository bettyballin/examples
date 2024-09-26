<!DOCTYPE html>
<html>
<head>
  <title>Download Blob</title>
</head>
<body>
  <script>
    // This function would retrieve a blob from somewhere
    // I'm just fetching a pdf and converting it for convenience
    function getBlob() {
      return fetch('https://uclit.ca/assets/documents/dummy.pdf').then((res) => res.blob());
    }

    getBlob().then((blob) => {
      const a = document.createElement('a');
      a.href = URL.createObjectURL(blob);
      a.textContent = 'DOWNLOAD';
      a.download = 'dummy.pdf';
      document.body.append(a);
    });
  </script>
</body>
</html>