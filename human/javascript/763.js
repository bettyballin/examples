const DOMPurify = require('dompurify');

// DOMPurify allows to define rules for Custom Elements. When using the CUSTOM_ELEMENT_HANDLING 
// literal, it is possible to define exactly what elements you wish to allow (by default, none are allowed).
//
// The same goes for their attributes. By default, the built-in or configured allow.list is used.
//
// You can use a RegExp literal to specify what is allowed or a predicate, examples for both can be seen below.
// The default values are very restrictive to prevent accidental XSS bypasses. Handle with great care!


var clean = DOMPurify.sanitize(
    '<foo-bar baz="foobar" forbidden="true"></foo-bar><div is="foo-baz"></div>',
    {
        CUSTOM_ELEMENT_HANDLING: {
            tagNameCheck: null, // no custom elements are allowed
            attributeNameCheck: null, // default / standard attribute allow-list is used
            allowCustomizedBuiltInElements: false, // no customized built-ins allowed
        },
    }
); 
console.log(clean);
 
var clean = DOMPurify.sanitize(
    '<foo-bar baz="foobar" forbidden="true"></foo-bar><div is="foo-baz"></div>',
    {
        CUSTOM_ELEMENT_HANDLING: {
            tagNameCheck: /^foo-/, // allow all tags starting with "foo-"
            attributeNameCheck: /baz/, // allow all attributes containing "baz"
            allowCustomizedBuiltInElements: false, // customized built-ins are allowed
        },
    }
); 
console.log(clean);
  
var clean = DOMPurify.sanitize(
    '<foo-bar baz="foobar" forbidden="true"></foo-bar><div is="foo-baz"></div>',
    {
        CUSTOM_ELEMENT_HANDLING: {
            tagNameCheck: (tagName) => tagName.match(/^foo-/), // allow all tags starting with "foo-"
            attributeNameCheck: (attr) => attr.match(/baz/), // allow all containing "baz"
            allowCustomizedBuiltInElements: true, // allow customized built-ins
        },
    }
); 
console.log(clean);