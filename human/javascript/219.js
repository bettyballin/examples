<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript">
        function QueryMyData() {
            var postUrl = './ProxyHandler.ashx?http://mydevpage/storage.ashx';
            var data = 'AssetNumber=102405';
            $.support.cors = true;
            $.ajax({
                type: "POST",
                url: postUrl,
                data: data,
                dataType: 'json',
                cache: false,
                success: function (result) {
                    if (result) {
                        if (result.error)
                            alert(result.error);
                        else
                            alert(result.id);
                    }
                },
                error: function (xhr, ajaxOptions, thrownError) {
                    alert('Unknow Error:' + thrownError + ajaxOptions + xhr.status + " " + xhr.statusText);
                }
            });
        }
        QueryMyData();
    </script>
</head>
<body>
</body>
</html>