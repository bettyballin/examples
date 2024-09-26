<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Executable Code</title>
</head>
<body>
  <button id="btn">Click me!</button>
  <div id="main-content"></div>
  <script>
    const btn = document.querySelector("#btn");

    btn.addEventListener("click", async () => {
      try {
        const data = await window.electronAPI.loadFile();
        document.getElementById("main-content").innerText = data;
      } catch (error) {
        console.log(error);
      }
    });
  </script>
</body>
</html>