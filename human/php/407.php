function make_links($text)
{
  return  preg_replace(
     array(
       '/(?(?=&lt;a[^&gt;]*&gt;.+&lt;\/a&gt;)
             (?:&lt;a[^&gt;]*&gt;.+&lt;\/a&gt;)
             |
             ([^="\']?)((?:https?|ftp|bf2|):\/\/[^&lt;&gt; \n\r]+)
         )/iex',
       '/&lt;a([^&gt;]*)target="?[^"\']+"?/i',
       '/&lt;a([^&gt;]+)&gt;/i',
       '/(^|\s)(www.[^&lt;&gt; \n\r]+)/iex',
       '/(([_A-Za-z0-9-]+)(\\.[_A-Za-z0-9-]+)*@([A-Za-z0-9-]+)
       (\\.[A-Za-z0-9-]+)*)/iex'
       ),
     array(
       function($match) {
         return stripslashes((strlen($match[2]) > 0 ? $match[1].'<a href="'.$match[2].'">'.$match[2].'</a>'.$match[3] : $match[0]));
       },
       '<a${1}',
       '<a${1} target="_blank">',
       function($match) {
         return stripslashes((strlen($match[2]) > 0 ? $match[1].'<a href="http://'.$match[2].'">'.$match[2].'</a>'.$match[3] : $match[0]));
       },
       function($match) {
         return stripslashes((strlen($match[2]) > 0 ? '<a href="mailto:'.$match[0].'">'.$match[0].'</a>' : $match[0]));
       }
       ),
       $text
   );
}

// Example usage:
$text = 'Hello, visit https://www.example.com or www.example.com for more information.';
echo make_links($text);