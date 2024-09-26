<!DOCTYPE html>
<html>
<head>
  <title>Executable Code</title>
</head>
<body>
  <img>
  <script>
    // This function would retrieve a blob from somewhere
    // I'm just fetching an image and converting it for convenience
    function getBlob() {
      return fetch(
        'https://wealthofgeeks.com/wp-content/uploads/2022/07/spongebob-rainbow-meme-imagination.jpg'
      ).then((res) => res.blob());
    }

    getBlob().then(
      (blob) => (document.querySelector('img').src = URL.createObjectURL(blob))
    );
  </script>
</body>
</html>