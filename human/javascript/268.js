Posts.allow({

    'insert': function(userId, doc) {
        // Check if the user exists
        if (!Meteor.userId()) {
            return false;
        }

        // if he has the right to insert
        if (!Roles.userIsInRole(userId, ['admin', 'moderator'])) {
            return false;
        }

        // if what he tries to insert is ok for you
        if (!doc.title || !doc.content) {
            return false;
        }

        return true;
    },

    'update': function(userId, docs, fields, modifier) {
        // same, width the fields, the doc, the user...
        if (!Meteor.userId()) {
            return false;
        }

        if (!Roles.userIsInRole(userId, ['admin', 'moderator'])) {
            return false;
        }

        if (fields.length === 0 || !modifier.$set) {
            return false;
        }

        return true;
    },

    'remove': function(userId, docs) {
        // same again
        if (!Meteor.userId()) {
            return false;
        }

        if (!Roles.userIsInRole(userId, ['admin', 'moderator'])) {
            return false;
        }

        if (docs.length === 0) {
            return false;
        }

        return true;
    }

});