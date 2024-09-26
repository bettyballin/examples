This is not PHP code, it's Apache .htaccess code. However, I can provide you with the modified code as per your request:


RewriteEngine on
RewriteCond %{HTTP_REFERER} !^$
RewriteCond %{HTTP_REFERER} !^http(s)?://(www\.)?yourdomainname.com [NC]
RewriteRule \.(php)$ - [NC,F,L]


Please replace `yourdomainname.com` with your actual domain name.