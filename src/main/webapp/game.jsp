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
            <c:if test="${game.isFinished}">
              <c:choose>
              	<c:when test="${game.playersScore[0]==game.playersScore[1]}">
              		<div id="winner" class="massive circular ui icon orange button">Draw</div>
              	</c:when> 
              	<c:otherwise>	
              		<div id="winner" class="massive circular ui icon green button">Player ${game.playersScore[0]>game.playersScore[1]?"1":"2"}  is the winner</div>
              	</c:otherwise>
              </c:choose>
            </c:if>
        </div>
    </div>

    <div class="main container">
        <div class="ui two column middle aligned very relaxed grid">
            <div class="column">
                <div id="board" class="ui four column padded grid ${game.ifReplay==true?"":"disabled" }">
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