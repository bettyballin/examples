html
<html>
<head>
<script type="text/javascript">
    function onBodyLoad() {

        String.prototype.split = function() { return 'foo'; }; // contaminate original window
        console.log(String.prototype.split); // yeah, it's contaminated

        var acr = document.getElementById("accessor");
        acr.onclick = function ()
        {
            var dummyFrame = document.createElement("iframe");
            document.body.appendChild(dummyFrame); 
            console.log(dummyFrame.contentWindow.String.prototype.split); // uncontaminated
        }
    }
</script>
</head>
<body onload="onBodyLoad()">
    <a href="#" id="accessor">Access iframe Window object</a>
</body>
</html>