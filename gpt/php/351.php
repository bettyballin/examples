
   $rss_feed_url = 'http://non-secure-rss-source.com/feed';
   $rss_content = file_get_contents($rss_feed_url);
   // Process the content if needed
   header('Content-Type: application/rss+xml');
   echo $rss_content;
   
