
<script>
    document.addEventListener('DOMContentLoaded', function() {
        // Extract the token from the URL
        var urlParams = new URLSearchParams(window.location.search);
        var token = urlParams.get('id');
        // Set the token as the value of the hidden field
