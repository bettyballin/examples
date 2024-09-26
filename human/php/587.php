<?php

function pollAjax()
{
?>
    <script>
        function pollAjax() {
            $.ajax({
                // ajax settings
            }).success(function(data) {
                // do something with our results
                doSomething(data);
                // Fire again to get the next set of results. 
                setTimeout(function() {pollAjax()}, 10);
            });
        }

        // Call the function to start the polling
        pollAjax();
    </script>
<?php
}
?>