&lt;?php
  $user_entered_variable = 10; // example value
?&gt;
&lt;script&gt;
  var inputNumber = &lt;?php echo json_encode($user_entered_variable); ?&gt;;
&lt;/script&gt;