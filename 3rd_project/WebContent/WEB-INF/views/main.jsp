<%@page import="com.model.SencingDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.model.SencingDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 
	String ctx = request.getContextPath();
    SencingDAO sdao = new SencingDAO();
    ArrayList<SencingDTO> list = new ArrayList<>();
    list = sdao.readData();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Astral by HTML5 UP</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="./assets/css/main.css" />
		<noscript><link rel="stylesheet" href="./assets/css/noscript.css" /></noscript>
		
		<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
        var data = google.visualization.arrayToDataTable([
        	['Time', 'Temp']
        	<%
        		for (SencingDTO sdto : list) {
        	%>
        	
        	,['<%= sdto.getUptime().substring(2)%>', <%= sdto.getTemp()%>]
          // 분단위는 (2), 시간단위는 (0,2)로 고칠 것! 
          <% }%>
        ]);

        var options = {
          title: '실내 온도',
          curveType: 'function',
          legend: { position: 'bottom' }
        };

        var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

        chart.draw(data, options);
      }
    </script>
		
		
		
</head>
<body class="is-preload" >

		<!-- Wrapper-->
			<div id="wrapper">

				<!-- Nav -->
					<nav id="nav">
						<a href="#" class="icon solid fa-home"><span>Home</span></a>
						<a href="#work" class="icon solid fa-folder"><span>Work</span></a>
						<a href="#test" class="icon solid fa-folder"><span>Test</span></a>
						<a href="#contact" class="icon solid fa-envelope"><span>Contact</span></a>
						<a href="https://twitter.com" class="icon brands fa-twitter"><span>Twitter</span></a>
					</nav>

				<!-- Main -->
					<div id="main">

						<!-- Me -->
							<article id="home" class="panel intro">
								<header>
									<h1>스마트 케어 봇</h1>
								<!-- 	<p>팀 나래궁</p> -->
									<form action="joinController" method="post">
									<div>
										<div class="row">
											<div class="col-6 col-12-medium">
												<input type="text" name="id" placeholder="ID" />
											</div>
											<br>
											<div class="col-6 col-12-medium">
											<br>
											</div>
											<div class="col-6 col-12-medium">
												<input type="text" name="pw" placeholder="PassWord" />
											</div>
											<br>
											<!-- <div class="col-12">
												<input type="text" name="subject" placeholder="길이 조절용" />
											</div> -->
											<div class="col-12">
												<input type="submit" value="로그인" />
												<input type="button" value="회원가입" onclick="location.href='<%=ctx%>/join.do'"/>
											</div>
										</div>
									</div>
								</form>
								
								</header>
								<!-- <a href="#work" class="jumplink pic">
									<span class="arrow icon solid fa-chevron-right"><span>See my work</span></span>
									<img src="./images/me.jpg" alt="" />
								</a> -->
							</article>

						<!-- Work -->
							<article id="work" class="panel">
								<header>
									<h2>저장된 영상 보기</h2>
								</header>
								<p>
									움직임이 감지된 보안 영상을 여기서 보면 되려나..?
								</p>
								<section>
									<div class="row">
										<div class="col-4 col-6-medium col-12-small">
											<a href="#" class="image fit"><img src="./images/pic01.jpg" alt=""></a>
										</div>
										<div class="col-4 col-6-medium col-12-small">
											<a href="#" class="image fit"><img src="./images/pic02.jpg" alt=""></a>
										</div>
										<div class="col-4 col-6-medium col-12-small">
											<a href="#" class="image fit"><img src="./images/pic03.jpg" alt=""></a>
										</div>
										<div class="col-4 col-6-medium col-12-small">
											<a href="#" class="image fit"><img src="./images/pic04.jpg" alt=""></a>
										</div>
										<div class="col-4 col-6-medium col-12-small">
											<a href="#" class="image fit"><img src="./images/pic05.jpg" alt=""></a>
										</div>
										<div class="col-4 col-6-medium col-12-small">
											<a href="#" class="image fit"><img src="./images/pic06.jpg" alt=""></a>
										</div>
										<div class="col-4 col-6-medium col-12-small">
											<a href="#" class="image fit"><img src="./images/pic07.jpg" alt=""></a>
										</div>
										<div class="col-4 col-6-medium col-12-small">
											<a href="#" class="image fit"><img src="./images/pic08.jpg" alt=""></a>
										</div>
										<div class="col-4 col-6-medium col-12-small">
											<a href="#" class="image fit"><img src="./images/pic09.jpg" alt=""></a>
										</div>
										<div class="col-4 col-6-medium col-12-small">
											<a href="#" class="image fit"><img src="./images/pic10.jpg" alt=""></a>
										</div>
										<div class="col-4 col-6-medium col-12-small">
											<a href="#" class="image fit"><img src="./images/pic11.jpg" alt=""></a>
										</div>
										<div class="col-4 col-6-medium col-12-small">
											<a href="#" class="image fit"><img src="./images/pic12.jpg" alt=""></a>
										</div>
									</div>
								</section>
							</article>

						<!-- Contact -->
							<article id="contact" class="panel">
								<header>
									<h2>CCTV 실시간 보기는 이쪽에서</h2>
								</header>
								<div>CCTV 영상</div>
							</article>
							
							<!-- test -->
							
							<article id="test" class="panel">
								<header>
									<h2>실내 정보</h2>
								</header>
								<div id="curve_chart" style="width: 900px; height: 500px"></div>
								<p>
									여기서 센서로 읽어들인 값들 그래프로 보여주면 될 듯.<br>
									화재 or 유해가스 등
								</p>
								<section>
									<div class="row">
										<div>그래프</div>
									</div>
								</section>
							</article>
							

					</div>

				<!-- Footer -->
					<div id="footer">
						<ul class="copyright">
							<li>&copy; Untitled.</li><li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
						</ul>
					</div>
			</div>
		<!-- Scripts -->
			<script src="./assets/js/jquery.min.js"></script>
			<script src="./assets/js/browser.min.js"></script>
			<script src="./assets/js/breakpoints.min.js"></script>
			<script src="./assets/js/util.js"></script>
			<script src="./assets/js/main.js"></script>





	</body>
</html>