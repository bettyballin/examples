This is not PHP code, it's Apache mod_rewrite configuration. You can't make it executable as PHP code. However, you can put it in a .htaccess file to make it work with Apache:


RewriteEngine On

# Sets your index script
RewriteRule ^$ index.php [L]

# Condition prevents redirect loops (when script is not found)
RewriteCond %{ENV:REDIRECT_STATUS} !^$
RewriteCond %{REQUEST_FILENAME} !-f

# Stop here if the file is not found after a redirect
RewriteRule ^(.*)$ notfound.php [L]

# Condition prevents redirect loops (when script is found)
RewriteCond %{ENV:REDIRECT_STATUS} ^$

# Forbid access directly to PHP files
RewriteRule ^.*?\.php$ forbidden [F,L]

# Make sure the filename does not actually exist (images, etc.)
RewriteCond %{REQUEST_FILENAME} !-f

# Append the .php extension to the URI
RewriteRule ^(.*)$ $1.php [L]


Save this as a `.htaccess` file in your website's root directory.