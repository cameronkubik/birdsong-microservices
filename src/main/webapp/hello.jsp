<!DOCTYPE html>
<%@ page import = "java.util.concurrent.ThreadLocalRandom" %>


<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hello</title>
</head>
<body>
    Hello ${name}
    <%= ThreadLocalRandom.current().nextInt(0, 10) %>
</body>
</html>