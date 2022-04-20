<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <meta charset="UTF-8">
    <title>Tourism</title>
    <link rel="stylesheet" href="css/sample.css">
</head>
<body>
<header>
    <p><a href="Servlet">Naar Huis</a></p>
    <p><a href="Servlet?command=showEnglish">EN</a></p>
</header>
<main>
    <article>
        <h1>Leuke vakanties</h1>
        <p>We <em>weten</em> hoe druk je het hebt. We <em>weten</em> hoe belangrijk je vakantie voor je is.
            Daarom willen we je helpen om de juiste keuze te maken.</p>
        <p>Deze website geeft je informatie over mogelijke bestemmingen. Zo kan je er zeker van zijn
            dat je de juiste keuze maakt. </p>
        <p>Request cookie was ${cookie.language.value}.</p>
        <p>The server asked the browser to set a cookie with value ${requestCookie} (response cookie).</p>
        <p>
            <a href="Servlet?command=somethingMore">Lees verder</a>.
        </p>
    </article>
</main>
</body>
</html>
