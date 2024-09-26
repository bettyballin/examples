const databaseText = "test input 1&lt;span&gt;test input 2&lt;/span&gt;&lt;script&gt; alert('EVIL SCRIPT')&lt;/scr" + "ipt&gt;&lt;span&gt;test input 3&lt;/span&gt;";
const p = document.body.appendChild(document.createElement('p'));
p.textContent = databaseText;