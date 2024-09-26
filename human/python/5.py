from xml.dom.minidom import Text, Element

t = Text()
e = Element('p')

t.data = '&lt;bar&gt;&lt;a/&gt;&lt;baz spam="eggs"&gt; &amp; blabla &amp;entity;&lt;/&gt;'
e.appendChild(t)

print(e.toxml())