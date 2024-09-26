<?php
$lang = 'php';
$escaped_code = htmlspecialchars('<?php echo "Hello World"; ?>');
echo "<pre><code class='language-$lang'>$escaped_code</code></pre>";
?>
<script src="https://cdnjs.cloudflare.com/ajax/libs/prism/1.27.0/prism.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/prism/1.27.0/plugins/autoloader/prism-autoloader.min.js"></script>