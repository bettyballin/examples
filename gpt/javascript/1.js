
   $(document).ready(function() {
       $('#ssn_input').on('blur', function() {
           var ssnValue = $(this).val();
           // Optionally, implement client-side encryption here
           $.ajax({
               type: 'POST',
               url: 'local_script.php',
               data: { ssn: ssnValue },
               success: function(response) {
                   // Handle the response returned from the PHP script
               },
               error: function(xhr, status, error) {
                   // Handle errors
               }
           });
       });
   });
   
