That's not JavaScript code, it's Apache HTTP Server configuration code. Here's the corrected version:


<IfModule mod_headers.c>
    Header set X-XSS-Protection "1; mode=block"
</IfModule>