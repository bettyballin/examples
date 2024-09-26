const user = {
  permissions: {
    can_create: true,
    can_update: true,
    can_delete: true,
    can_read: true
  }
};

if (user.permissions.can_create) {
  console.log("Display create view");
}

if (user.permissions.can_update) {
  console.log("Display update view");
}

if (user.permissions.can_delete) {
  console.log("Display delete view");
}

if (user.permissions.can_read) {
  console.log("Display read view");
}