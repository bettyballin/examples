<!DOCTYPE html>
<html>
<head>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
  <input type='hidden' id='params_' name='params' value='${params}' />
  <input type="hidden" id="csrftoken_" name="${_csrf.parameterName}" value="${_csrf.token}" />
  <button id="download">Download</button>
  <script>
    $(document).ready(function () {
      $('#download').click(function(){                
        var params = $('#params_').clone();
        var csrftoken = $("#csrftoken_").clone();
        $('<form target="_blank" action="report" method="post"></form>')
          .append(params)
          .append(csrftoken)
          .appendTo('body')
          .submit()
          .remove();
      });
    });
  </script>
</body>
</html>