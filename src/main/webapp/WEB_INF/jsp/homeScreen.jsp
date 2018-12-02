<!-- <!DOCTYPE html>


<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home Screen</title>
</head>
<body>
    Home Screen
    <p>
        Your name: <% ${name} %>
    </p>
</body>
</html> -->

<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
    Welcome ${name}!!
</div>
<%@ include file="common/footer.jspf"%>