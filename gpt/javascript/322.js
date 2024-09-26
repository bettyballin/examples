
Java.perform(function () {
    var dClass = Java.use("e.a.x.d");

    dClass.asd.overload().implementation = function() {
        // Call the original method first
        this.asd();

        // Retrieve all fields of the class
        var fields = dClass.class.getDeclaredFields();
        
        // Filter out the field with the specific type you're looking for
        for (var i = 0; i < fields.length; i++) {
            var field = fields[i];
            if (field.getType().getName() === 'e.a.x.e') {
                // Make the field accessible if it is private
                field.setAccessible(true);

                // Read the value of the field and cast it to the correct type
                var fieldValue = field.get(this);
                var
