<!DOCTYPE html>
<html>
<head>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
  <canvas id="c" width="100" height="100"></canvas>
  <button class="button">Apply Filter</button>
  <script>
    var ctx = document.getElementById('c').getContext('2d'),
        img = new Image();
    img.crossOrigin = 'anonymous';
    img.src = 'https://lh3.googleusercontent.com/-LAFgeyNL894/AAAAAAAAAAI/AAAAAAAAAAA/-CWBGs9xLXI/s96-c/photo.jpg';

    img.onload = function() {
        ctx.drawImage(img, 0, 0);
        try {
            var imgData = ctx.getImageData(0, 0, 100, 100);
            $('.button').on('click', function(e) {
                e.preventDefault();
                applyFilter(ctx, imgData);
            });
        } catch(err) {
            $('.button').hide();
            $('body').append("Access denied");
            console.log(err);
        }
    };
    function applyFilter(ctx, data) {
        for (var x = 0; x < data.width; x++) {
            for (var y = 0; y < data.height; y++) {
                var index = 4 * (y * data.width + x);
                data.data[index] = data.data[index] - 50; //r
                data.data[index+1] = data.data[index+1] - 50; //g
                data.data[index+2] = data.data[index+2] - 50; //b
                data.data[index+3] = data.data[index+3]; //a (don't change alpha channel)
            }
        }
        ctx.putImageData(data, 0, 0);
    }
  </script>
</body>
</html>