<form action="derp.html" method="POST" target="myNewWindow">
    <input type="hidden" value="derp" name="name"/>
    <input type="hidden" value="derp" name="lname"/>
    <a href="#" onclick="window.open('myNewWindow');this.parentNode.submit()">Click to open in a new window</a>
</form>