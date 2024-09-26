html
<div><label><input type="checkbox" checked="checked"> Capture</label></div>
<div><input type="button" value="[1, 2]" onclick="document.querySelector('textarea').value += this.value + '\n';" /> 
<input type="button" value="Array(1, 2);" onclick="document.querySelector('textarea').value += this.value + '\n';" /> 
<input type="button" value="{foo: 'bar'}" onclick="document.querySelector('textarea').value += this.value + '\n';" /> 
<input type="button" value="({}).foo = 'bar';" onclick="document.querySelector('textarea').value += this.value + '\n';" />
</div>
<div><textarea></textarea></div>