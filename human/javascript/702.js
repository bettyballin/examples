let htmlOpenTags = [];

// Sample data for demonstration purposes
let tags = [
  { tagType: 'open', commentTag: 'div' },
  { tagType: 'open', commentTag: 'p' },
  { tagType: 'close', commentTag: 'p' },
  { tagType: 'close', commentTag: 'div' },
];

tags.forEach((tag) => {
  let { tagType, commentTag } = tag;

  if (tagType === 'close' && htmlOpenTags.includes(commentTag)) {
    htmlOpenTags.splice(htmlOpenTags.lastIndexOf(commentTag), 1);
    console.log(`Closed tag: ${commentTag}`);
  } else if (tagType === 'open') {
    htmlOpenTags.push(commentTag);
    console.log(`Opened tag: ${commentTag}`);
  }
});

console.log(htmlOpenTags);