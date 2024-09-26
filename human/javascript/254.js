const input = '{"title": "Example Organisation"}';
const organisation = JSON.parse(input);
const list = document.body;

var title = document.createElement('li');
title.setAttribute('class', 'organisation-title');
title.innerHTML = organisation.title;
list.appendChild(title);