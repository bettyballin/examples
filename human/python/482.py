html_code = b'&lt;!DOCTYPE html&gt;\n&lt;html&gt;\n&lt;head&gt;\n&lt;style&gt;\ndiv.cities {\n    background-color:black;\n    color:white;\n    margin:20px;\n    padding:20px;\n} \n&lt;/style&gt;\n&lt;/head&gt;\n&lt;body&gt;\n&lt;h1 align="center"&gt; Here are three big cities &lt;/h1&gt;\n&lt;div class="cities"&gt;\n&lt;h2&gt;London&lt;/h2&gt;\n&lt;p&gt;London is the capital of England and it\'s been a British settlement since 2000 years ago. &lt;/p&gt;\n&lt;/div&gt;\n&lt;div class="cities"&gt;\n&lt;h2&gt;Paris&lt;/h2&gt;\n&lt;p&gt;Paris is the capital city of France. It was declared capital since 508.&lt;/p&gt;\n&lt;/div&gt;\n&lt;div class="cities"&gt;\n&lt;h2&gt;Tokyo&lt;/h2&gt;\n&lt;p&gt;Tokyo is the capital of Japan and one of the most populated cities in the world.&lt;/p&gt;\n&lt;/div&gt;\n&lt;/body&gt;\n&lt;/html&gt;'

with open('index.html', 'wb') as f:
    f.write(html_code.replace(b'&lt;', b'<').replace(b'&gt;', b'>'))

import webbrowser
webbrowser.open('index.html')