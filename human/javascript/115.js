html
<!DOCTYPE html>
<html>
   <body>
        <div> stuff </div>
        <script>
            const needSpecialHandlingForMixedMode = true; // replace with your logic
            if (needSpecialHandlingForMixedMode) {
                const warnDiv = document.createElement('div');
                warnDiv.id = 'secureWarn';
                warnDiv.textContent = 'WARNING: This page has limited functionality, allow mixed content';
                document.body.appendChild(warnDiv);
            }
        </script>
        <iframe src="URL_WHICH_IS_MAYBE_INSECURE"></iframe>
        <script>
            if (needSpecialHandlingForMixedMode) {
                const baseUrl = window.location.href.replace('https', 'http');
                const script = document.createElement('script');
                script.src = baseUrl + '/scripts/security-warning.js';
                document.body.appendChild(script);
            }
        </script>
   </body>
</html>