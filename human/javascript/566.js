<?xml version="1.0"?>
<!DOCTYPE html>
<html>
<head>
  <bindings xmlns="http://www.mozilla.org/xbl" xmlns:html="http://www.w3.org/1999/xhtml">
    <binding id="mycode">
      <implementation>
        <constructor>
          <![CDATA[
            alert("XBL script executed.");
          ]]>
        </constructor>
      </implementation>
    </binding>
  </bindings>
</head>
<body>
  <div style="-moz-binding: url(#mycode)"></div>
</body>
</html>