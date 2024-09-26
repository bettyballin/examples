Here is the executable JavaScript code:


html
<html>
<head>
    <title>News Verifier</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    <script src="popup.js"></script>
    <script>
        function GetResult() {
            var news = document.getElementById("news").value;
            // Rest of the logic to verify the news goes here
            alert("News Verified: " + news);
        }
    </script>
</head>
<body>
    <div class="popupbox">
        <img src="NV.png" alt="Logo" width="100" height="100" class="image">
        <h1>News Verifier</h1>
        <form>
            <p class="instruct">Copy and paste the news below</p>
            
            <textarea id="news" class="input" name="paragraph_text" cols="50" rows="10" placeholder="Paste here"></textarea>
            <br><br><br>
            <input class="button" type="button" onclick="GetResult();" value="Verify">            
            <br><br>

           
        </form>
        
    </div>

</body>
</html>