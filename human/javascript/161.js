html
<!DOCTYPE html>
<html>
<head>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
  <span class="day_field" data-date="13-02-2013" data-task="4">13.02.2013</span>

  <script>
    $('.day_field').on('click',function(){
      var date = $(this).data("date");
      var task_id = $(this).data("task");
      //place for some validation
      $.post('book_task.php',{task_id: task_id, date: date},function(data){
        console.log(data);
      });
    });
  </script>
</body>
</html>