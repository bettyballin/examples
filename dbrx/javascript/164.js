<script>
  // Check if Do Not Track is enabled
  var dnt = navigator.doNotTrack || window.doNotTrack || navigator.msDoNotTrack;
  
  // If DNT is set to "1" or "yes" don't load GA tracking code
  if (dnt == '1' || dnt == 'yes') {
    console.log('Google Analytics not loaded due to Do Not Track setting');
  } else {
    // Load Google Analytics tracking code here
    (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
    (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
    m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
    })(window,document,'script','https://www.google-analytics.com/analytics.js','ga');

    ga('create', 'UA-XXXXX-Y', 'auto');
    ga('send', 'pageview');
  }
</script>