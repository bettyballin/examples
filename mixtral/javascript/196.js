// Import DOMPurify library
import DOMPurify from 'dompurify';

// Assuming onePersonArticle is an HTML element and member is an object with the respective properties
const onePersonArticle = document.getElementById('one-person-article');
const member = {
  name: 'John Doe',
  phone: '123-456-7890',
  cwb: 'Codewars Badge',
  cwa: 'Codewars Account',
  fccb: 'FreeCodeCamp Badge',
  fcca: 'FreeCodeCamp Account',
  notes: 'Some notes about the member'
};

// Using DOMPurify to sanitize content
const content = `
  NAME: ${member.name}
  PHONE: ${member.phone}
  CODEWARS: ${member.cwb} - ${member.cwa}
  FREECODECAMP: ${member.fccb} - ${member.fcca}
  NOTES: ${member.notes}
  â
  âŽ
`;

const cleanContent = DOMPurify.sanitize(content);
onePersonArticle.innerHTML = cleanContent;

// or

onePersonArticle.innerHTML = DOMPurify.sanitize(`
  NAME: ${member.name}
  PHONE: ${member.phone}
  CODEWARS: ${member.cwb} - ${member.cwa}
  FREECODECAMP: ${member.fccb} - ${member.fcca}
  NOTES: ${member.notes}
  â
  âŽ
`);