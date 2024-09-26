const dbRecs = [
  { user_name: 'John', group_id: 1 },
  { user_name: 'John', group_id: 2 },
  { user_name: 'Jane', group_id: 3 },
  { user_name: 'Jane', group_id: 4 },
];

const gMapping = {};

// Map records to dictionaries
dbRecs.forEach(rec => {
  const userName = rec.user_name;
  const groupId = rec.group_id;

  // Check if the user_name is already in our mapping object and that it has its own property (not inherited)
  if (!gMapping.hasOwnProperty(userName) || !Array.isArray(gMapping[userName])) {
    gMapping[userName] = [];
  }

  gMapping[userName].push(groupId);
});

console.log(gMapping);