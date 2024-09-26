<input type="hidden" name="token" id="token" value="<?php echo $_SESSION['token'];?>">

<script>
  $(document).ready(function(){
    var token = $('#token').val();
    $.ajax({
      type: 'POST',
      url: 'your_backend_url.php',
      data: {token: token},
      success: function(data){
        console.log(data);
      }
    });
  });
</script>