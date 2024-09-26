html
<!DOCTYPE html>
<html>
<head>
</head>
<body>
    <input type="file" id="files" name="files[]" multiple="multiple" />
    <output id="list">
    </output>
    <script>
        function handleFileSelect(evt) {
            var files = evt.target.files; // FileList object
            // Loop through the FileList and render image files as thumbnails.
            for (var i = 0, f; f = files[i]; i++) {
                console.log("for call");

                var reader = new FileReader();

                // Closure to capture the file information.
                reader.onload = (function(theFile) {
                    return function(e) {
                        // Render thumbnail.
                        var span = document.createElement('span');
                        console.log(e.target.result);
                        var spl = e.target.result.split(",");
                        console.log("data:image/png;base64," + spl[1]);
                        var el = "data:image/png;base64," + spl[1];

                        span.innerHTML = ['<img class="thumb" src="', el, '" title="', escape(theFile.name), '"/>'].join('');
                        document.getElementById('list').insertBefore(span, null);
                    };
                })(f);

                // Read in the image file as a data URL.
                reader.readAsDataURL(f);
            }
        }

        document.getElementById('files').addEventListener('change', handleFileSelect, false);
    </script>
</body>
</html>