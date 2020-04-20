<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Zemoga test</title>

    <!-- Custom fonts -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <!-- Theme CSS -->
    <spring:url value="/css/main.css" var="mainCss"/>
    <link href="${mainCss}" rel="stylesheet"/>

</head>

<body id="page-top">

<!-- Masthead -->
<header class="masthead bg-secondary text-white text-center">
    <div class="container d-flex align-items-center flex-column">
        <h1 class="masthead-heading text-uppercase mb-0">Tweets</h1>
    </div>
</header>
<c:choose>
    <c:when test="${empty portfolio}">
        <section class="message">
            <div class="alert alert-danger" role="alert">
                Oooops this user has not registered!!
            </div>
        </section>
    </c:when>
    <c:otherwise>
        <!-- Content Section -->
        <section class="page-section">
            <div class="container my-4">
                <div class="row">
                    <div class="col-sm">
                        <div class="center-img">
                            <img src="${portfolio.imageUrl}">
                        </div>
                        <div class="card">
                            <div class="card-header bg-info">
                                <h3>${portfolio.title}'s Timeline</h3>
                            </div>
                            <div class="card-body">
                                <h1>${portfolio.twitterUserName}</h1>
                                <ul>
                                    <c:forEach items="${tweets}" var="tweet">
                                        <li><a href="#" class="fa fa-twitter"></a>${tweet.text}</li>
                                    </c:forEach>
                                </ul>
                                <a href="#" class="">Go to account ></a>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm">
                        <h1>${portfolio.title}</h1>
                        <div class="card">
                            <div class="card-header bg-info">
                                <h3>My work experience</h3>
                            </div>
                            <div class="card-body">
                                <p class="card-text">${portfolio.description}</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </c:otherwise>
</c:choose>
</body>

</html>
