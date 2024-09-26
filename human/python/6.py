import xml.etree.ElementTree as ET

e = ET.fromstring('<p>&lt;bar&gt;&lt;a/&gt;&lt;baz spam=&quot;eggs&quot;&gt; &amp; blabla &amp;entity;&lt;/&gt;</p>')

print(e.toxml())