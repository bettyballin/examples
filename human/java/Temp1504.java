<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Form Example</title>
</head>
<body>
    <form action="${fn:escapeXml(form_url)}" method="POST" class="navbar-form navbar-right">
        <!-- Add your form elements here -->
        <label for="exampleInput">Example Input:</label>
        <input type="text" id="exampleInput" name="exampleInput">
        <button type="submit">Submit</button>
    </form>
</body>
</html>