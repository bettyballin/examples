// Create a sample table in the DOM
var table = $('<table>');
$('body').append(table);

// Sample row data
var row = {
  title: 'Sample Row',
  description: 'This is a sample row.'
};

// The original code, now executable
$('table').append(
  $('<tr>', {title: row.title}).append(
    $('<td>', {text: row.description})
  )
);