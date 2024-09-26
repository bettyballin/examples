<!doctype html>
<title>simple noopener test</title>

<a onclick="getUrl()" rel="noreferrer noopener">Case 1: click here to open a new tab that <b>won't</b> have access to the window object of this document (despite the 'noopener')</a>

<p>
<a href="http://example.com" rel="noreferrer noopener" target="_blank">Case 2: click here to open a new tab that <b>won't</b> have access to the window object of this document (because of the 'noopener')</a>

<script>
var getUrl = function() {
  var newTab = window.open("http://example.com", '_blank', 'noopener,noreferrer');
  newTab.opener = null;
}
</script>