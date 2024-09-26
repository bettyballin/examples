
document.getElementById('imageInput').addEventListener('change', function(event) {
    var file = event.target.files[0];
    var reader = new FileReader();

    reader.onload = function(readerEvent) {
        var image = new Image();
        
        image.onload = function(imageEvent) {
            var canvas = document.createElement('canvas'),
                max_size = 
