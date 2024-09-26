Here is the corrected JavaScript code:


function handleFileSelect(evt) {
  var files = evt.target.files; // FileList object

  for (var i = 0, f; f = files[i]; i++) {
    if (!f.type.match('image.*')) continue;

    var reader = new FileReader();

    reader.onloadend = function(e) { 
      document.getElementById("img").src = e.target.result;
    };

    // Read in the image file as a data URL.
    reader.readAsDataURL(f);
  }
}

document.getElementById('file-input').addEventListener('change', handleFileSelect, false);