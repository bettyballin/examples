
const gMapping = {};

// A function to check if the property is potentially dangerous
function isUnsafeProperty(property) {
  return ['__proto__', 'constructor', 'prototype'].includes(property);
}

dbRecs.forEach(rec => {
  const userName = rec.user_name;
  const groupId = rec.group_id;

  // Check if the userName is safe to use as a property
  if (isUnsafeProperty(userName)) {
    // Handle the unsafe property name case, e.g., ignore it or log a warning
    console.warn(`Attempted to set unsafe property on gMapping: ${userName}`);
  } else {
    gMapping[userName] = gMapping[userName] || [];
    gMapping[userName].push(groupId);
  }
});

