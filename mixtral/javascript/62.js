window.resolveLocalFileSystemURL(imagePath, function (fileEntry) {
    fileEntry.file(function (fileObj) {
        var reader = new FileReader();

        reader.onloadend = function () {
            console.log("Result: " + this.result);

            let imgElement = document.createElement('img');
            imgElement.src = this.result;

            var canvas = document.getElementById('canvas');
            var context = canvas.getContext('2d');
            var canvasWidth = canvas.width;
            var canvasHeight = canvas.height;

            context.drawImage(imgElement, 0, 0, canvasWidth, canvasHeight);
        };

        reader.readAsDataURL(fileObj);
    }, function (error) {
        console.log("Error: " + error);
    });
}, function (error) {
    console.log("Error: " + error);
});