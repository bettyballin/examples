<!DOCTYPE html>
<html>
<head>
    <title>Navigation</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
    <ul id="Navigation">
        <li class="nav_btn" data-link="pages/home.php">Home</li>
        <li class="nav_btn" data-link="pages/news.php">News</li>
        <li class="nav_btn" data-link="pages/about_us.php">About Us</li>
    </ul>

    <script type="text/javascript">
        $(document).ready(function() {
            $("#Navigation").on("click", ".nav_btn", function() {
                window.location = $(this).data("link");
            });
        });
    </script>
</body>
</html>