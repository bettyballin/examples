html
<body data-current-url="<?php echo htmlspecialchars(get_current_page_url()); ?>">
  <script>
    var current = document.body.getAttribute('data-current-url');
    var form_data = 'example=form&data=here'; // replace with your actual form data
    var pageUrl = current + '?' + form_data;
    console.log(pageUrl);
  </script>
</body>