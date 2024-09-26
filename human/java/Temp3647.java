jsp
<%@ taglib prefix="s" uri="/struts-tags" %>

<html lang="en">
<head>
    <!-- content removed for brevity -->

    <s:url var="jqueryJs" value='/js/jquery-2.1.4.min.js' encode='false' includeParams='none'/>
    <s:script src="%{jqueryJs}"/>
    <!-- other resources... now handling inline sources --> 
    <s:script type="text/javascript">
        $(function () {
            var alerts = $('ul.alert').wrap('<div />');
            alerts.prepend('<a class="close" data-dismiss="alert" href="#">×</a>');
            alerts.alert();
        });
    </s:script>

    <!-- ... -->
</head>
<body>
    <!-- Body content here -->
</body>
</html>