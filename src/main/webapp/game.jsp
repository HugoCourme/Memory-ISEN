<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/semantic.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
</head>

<body id="example" class="site">
    <div class="ui fixed inverted main menu">
        <div class="container">
            <a class="launch item"><i class="content icon"></i></a>
            <div class="title item">
                <b>Memory Hugo-Louis</b>
            </div>
        </div>
    </div>

    <div id="header" class="header segment">
        <div class="container">
            <h2 class="ui dividing header">Memory</h2>
            <div class="introduction">
                <p>Simple memory app that makes use of JEE servlets</p>
            </div>
        </div>
    </div>

    <div class="main container">
        <div class="ui two column middle aligned very relaxed grid">
            <div class="column">
                <div id="board" class="ui four column padded grid">
                <c:forEach items ="${game.cards}" var="card">
                	<c:choose>
                		<c:when test="${card.cssColor==null}">
                			<div class="column"><a href="?playCard=${card.index}" class="ui icon massive button"></a></div>
                		</c:when>
                		<c:otherwise>
                			<div class="column disabled"><a href="" class="ui icon massive ${card.cssColor} button"></a></div>
                		</c:otherwise>
                	</c:choose>
                </c:forEach>
<!--                         <div class="column"><a href="?playCard=1" class="ui icon massive red button"></a></div> -->
<!--                         <div class="column"><a href="?playCard=2" class="ui icon massive orange button"></a></div> -->
<!--                         <div class="column"><a href="?playCard=3" class="ui icon massive purple button"></a></div> -->
<!--                         <div class="column"><a href="?playCard=4" class="ui icon massive blue button"></a></div> -->
<!--                         <div class="column"><a href="?playCard=5" class="ui icon massive teal button"></a></div> -->
<!--                         <div class="column"><a href="?playCard=6" class="ui icon massive pink button"></a></div> -->
<!--                         <div class="column disabled"><a href="?playCard=7" class="ui icon massive yellow button"></a></div> -->
<!--                         <div class="column"><a href="?playCard=8" class="ui icon massive green button"></a></div> -->
                </div>    
            </div>
	        <div class="column">
	            <div id="score">
	            <div class="header"><h1>Score</h1></div>
	                <div class="ui horizontal statistics">
	                    <div id =${game.currentPlayer==0?"focus":"z"} class="statistic">
	                        <div class="value">${game.playersScore[0]}</div>
	                        <div class="label">Player 1</div>
	                    </div>
	                    <div id =${game.currentPlayer==1?"focus":"z"} class="statistic">
	                        <div class="value">${game.playersScore[1]}</div>
	                        <div class="label">Player 2</div>
	                    </div>
	                </div>
	            </div>
	        </div>
	   </div>
    </div>
    <div class="container">
        <a href="?reset" class="ui red button" id="reset">Reset game</a>
    </div>

</body>

</html>