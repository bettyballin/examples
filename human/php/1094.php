<?php
function get_current_page_url() {
  $pageURL = 'http';
  if ($_SERVER["HTTPS"] == "on") {$pageURL .= "s";}
  $pageURL .= "://";
  if ($_SERVER["SERVER_PORT"] != "80") {
    $pageURL .= $_SERVER["SERVER_NAME"].":".$_SERVER["SERVER_PORT"].$_SERVER["REQUEST_URI"];
  } else {
    $pageURL .= $_SERVER["SERVER_NAME"].$_SERVER["REQUEST_URI"];
  }
  return $pageURL;
}
?>

<body data-current-url="<?php echo htmlspecialchars(get_current_page_url()); ?>">
  <script>
    var current = document.body.getAttribute('data-current-url');
    var formData = 'your_form_data_here'; // replace with your form data
    var pageUrl = current + '?' + formData;
  </script>