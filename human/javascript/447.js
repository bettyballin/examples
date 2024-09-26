<div id="myDynamicData" data-partnerId="<%=Server.HTMLEncode(Request.QueryString["partnerid"])%>" data-id="<%=Server.HTMLEncode(Request.QueryString["id"])%>"></div>

<script>
  const myDynamicData = document.getElementById('myDynamicData');
  const partnerId = myDynamicData.getAttribute('data-partnerId');
  const id = myDynamicData.getAttribute('data-id');
  console.log(partnerId, id);
</script>