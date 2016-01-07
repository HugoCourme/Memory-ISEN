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
                        <a href="?playCard=1" class="column"><div class="ui icon massive red button">1</div></a>
                        <a href="?playCard=2" class="column"><div class="ui icon massive orange button">2</div></a>
                        <a href="?playCard=3" class="column"><div class="ui icon massive purple button">3</div></a>
                        <a href="?playCard=4" class="column"><div class="ui icon massive blue button">4</div></a>
                        <a href="?playCard=5" class="column"><div class="ui icon massive teal button">5</div></a>
                        <a href="?playCard=6" class="column"><div class="ui icon massive pink button">6</div></a>
                        <a href="?playCard=7" class="column"><div class="ui icon massive yellow button">7</div></a>
                        <a href="?playCard=8" class="column"><div class="ui icon massive green button">8</div></a>
                </div>    
            </div>
	        <div class="column">
	            <div class="">
	            <div class="header"><h1>Score</h1></div>
	                <div class="ui horizontal  statistics">
	                    <div class="statistic">
	                        <div class="value">22</div>
	                        <div class="label">Player 1</div>
	                    </div>
	                    <div class="statistic">
	                        <div class="value">28</div>
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