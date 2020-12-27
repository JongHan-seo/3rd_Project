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
    String name = (String) session.getAttribute("name");
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
        <%-- var data1 = google.visualization.arrayToDataTable([
        	['Time', 'Temp']
        	<%
        		for (SencingDTO sdto : list) {
        	%>
        	
        	,['<%= sdto.getUptime().substring(2)%>분', <%= sdto.getTemp()%>]
          // 분단위는 (2), 시간단위는 (0,2)로 고칠 것! 
          <% }%>
        ]); --%>
        
        var data1 = google.visualization.arrayToDataTable([
        	['Time', 'Temp'],
        	['05시', 18],['06시', 18],['07시', 20],['08시', 21],['09시', 24],
        	['10시', 26],['11시', 26],['12시', 25],['13시', 24],['14시', 25]
        ]);

        var options1 = {
          title: '실내 온도 (℃)',
          vAxis: {minValue: 0, maxValue: 40},
          legend: { position: 'top' },
          series: {
              0: { color: '#F15F5F' }
          },
          width: 700,
          height: 400
        };
        
        <%-- var data2 = google.visualization.arrayToDataTable([
        	['Time', 'Water']
        	<%
        		for (SencingDTO sdto : list) {
        	%>
        	
        	,['<%= sdto.getUptime().substring(2)%>분', <%= sdto.getWater()%>]
          // 분단위는 (2), 시간단위는 (0,2)로 고칠 것! 
          <% }%>
        ]); --%>
        var data2 = google.visualization.arrayToDataTable([
        	['Time', 'Temp'],
        	['05시', 15],['06시', 14],['07시', 15],['08시', 15],['09시', 19],
        	['10시', 24],['11시', 21],['12시', 20],['13시', 20],['14시', 21]
        ]);

        var options2 = {
          title: '실내 습도(％)',
          vAxis: {minValue: 10, maxValue: 75},
          legend: { position: 'top' },
          width: 700,
          height: 400
        };
        
        
        var data3 = google.visualization.arrayToDataTable([
        	['Time', 'Temp'],
        	['34분', 123],['35분', 98],['36분', 102],['37분', 281],['38분', 107],
        	['39분', 470],['40분', 482],['41분', 342],['42분', 110],['43분', 102]
        ]);
        
       <%--  var data3 = google.visualization.arrayToDataTable([
        	['Time', 'Gas']
        	<%
        		for (SencingDTO sdto : list) {
        	%>
        	
        	,['<%= sdto.getUptime().substring(2)%>분', <%= sdto.getGas()%>]
          // 분단위는 (2), 시간단위는 (0,2)로 고칠 것! 
          <% }%>
        ]); --%>

        var options3 = {
          title: '유해가스(ppm)',
          vAxis: {minValue: 0, maxValue: 650},
          legend: { position: 'top' },
          series: {
              0: { color: '#8C8C8C' }
          },
          width: 700,
          height: 400
        };
        
        var chart1 = new google.visualization.AreaChart(document.getElementById('curve_chart1'));
        var chart2 = new google.visualization.AreaChart(document.getElementById('curve_chart2'));
        var chart3 = new google.visualization.AreaChart(document.getElementById('curve_chart3'));
        
        chart1.draw(data1, options1);
        chart2.draw(data2, options2);
        chart3.draw(data3, options3);
        
        
      }
    </script>
		
		
		
</head>
<body class="is-preload" >

		<!-- Wrapper-->
			<div id="wrapper">

				<!-- Nav -->
					<nav id="nav">
						<a href="#" class="icon solid fa-home" id = "loginhome"><span>Home</span></a>
						<a href="#work" class="icon solid fa-folder" id = "loginwork"><span>Work</span></a>
						<a href="#test" class="icon solid fa-folder" id = "logintest"><span>Test</span></a>
						<a href="#contact" class="icon solid fa-envelope" id = "logincontact"><span>Contact</span></a>
					</nav>

				<!-- Main -->
					<div id="main">

						<!-- Me -->
							<article id="home" class="panel intro">
								<header>
									<h1>이동형 카메라 봇<br>Bangle</h1>
									
								<!-- 	<p>팀 나래궁</p> -->
									<form action="<%=ctx %>/login.do" method="post">
									<div>
										<div class="row">
											<div class="col-6 col-12-medium"><br>
											<div class="col-6 col-12-medium">
												<input type="text" name="id" placeholder="ID" />
											</div>
											<div class="col-6 col-12-medium"><br>
											</div>
											<div class="col-6 col-12-medium">
												<input type="text" name="pw" placeholder="PassWord" />
											</div>
											<br>
											<div class="col-12">
												<input type="submit" value="로그인" id = "login" />
												<input type="button" value="회원가입" onclick="location.href='<%=ctx%>/joinpage.do'"/>
											</div>
											<div class="loginck" align="right" id="loginck"></div>
										</div>
									</div>
								</form>
								
								</header>
							</article>

						<!-- Work -->
							<article id="work" class="panel">
							 
										
								<header>
									<h2>영상 확인</h2>
									<div><a href="#" onClick="window.open('http://192.168.137.141:8081','실시간 CCTV 확인','width=400, height=350, toolbar=no, menubar=no, scrollbars=no, resizable=yes');return false;">실시간 CCTV 확인</a></div>
								</header>
								<p>
									
								</p>
								<section>
								 	<div class="row">
										<div class="col-4 col-6-medium col-12-small">
										<video class="a" src ="./video/04-20201226120135.mkv" controls></video> 
										</div>
										<div class="col-4 col-6-medium col-12-small">
											<video class="a" src ="./video/01-20201224191142.mkv" controls></video>
											<!-- <a href="#" class="image fit"><img src="./images/pic02.jpg" alt=""></a> -->
										</div>
										<div class="col-4 col-6-medium col-12-small">
											<video class="a" src ="./video/05-20201221111005.mkv" controls></video>
											<!-- <a href="#" class="image fit"><img src="./images/pic03.jpg" alt=""></a> -->
										</div>
										<div class="col-4 col-6-medium col-12-small">
											<video class="a" src ="./video/15-20201222164315.mkv" controls></video>
										</div>
										<!-- <div class="col-4 col-6-medium col-12-small">
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
										</div> -->
									</div> 
								</section> 
							</article>

						<!-- Contact -->
							<article id="contact" class="panel">
								<header>
									<h2>연락처</h2>
									<br><br>
									<h4>광주 남구 송암로 60 CGI센터 2층 스마트그리드 인재개발원</h4>
								</header>
								<!-- <div><a href = http://192.168.137.244:8081/>CCTV 보기</a></div> -->
								<div></div>
								<!-- <iframe class ="frame" src="http://192.168.137.244:8081/" ></iframe> -->
								<!-- <iframe class ="frame" src="https://dbcut.com/" ></iframe> -->
							</article>
							
							<!-- test -->
							
							<article id="test" class="panel">
								<header>
									<h2>실내 정보</h2>
								</header>
								<div id="curve_chart1"></div>
								<div></div>
								<div id="curve_chart2"></div>
								<div></div>
								<div id="curve_chart3"></div>
								<p>
									유해가스가 400ppm이상이거나 화재가 감지되면<br>
									봇의 알람 기능이 활성화 됩니다.
								</p>
								<section>
									<div class="row">
										<!-- <div>그래프</div> -->
									</div>
								</section>
							</article>
							

					</div>

				<!-- Footer -->
					<div id="footer">
						<ul class="copyright">
							<li>&copy; Untitled.</li><li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
							<li><a href="<%=ctx%>/logout.do" id ="logout">로그아웃</a></li>
						</ul>
					</div>
			</div>
		<!-- Scripts -->
			<script src="./assets/js/jquery.min.js"></script>
			<script src="./assets/js/browser.min.js"></script>
			<script src="./assets/js/breakpoints.min.js"></script>
			<script src="./assets/js/util.js"></script>
			<script src="./assets/js/main.js"></script>

	<script type="text/javascript">


<%if (name != null) {%>
window.location.href = "<%=ctx%>/main.do#work";
/* $("#loginhome").attr('href','#work'); */
<%}%>

<%-- <%if(name == null){%>
$("#loginwork").attr('href','#');
$("#logintest").attr('href','#');
$("#logincontact").attr('href','#');


<%}%> --%>


	

<%-- $('#login').on('click',function(){
		
		$.ajax({
			// 눈으로 보이는 url에는 변동이 없지만 네트워크상에서는 볼 수 있어서 post방식 필요!
			url : "<%=ctx%>/login.do",
			type : "POST",
			data : 'id='+$('#id').val()+'&pw='+$('#pw').val(),
			success : function(result){
				console.log(result);
				if(<%=name %> === null){
					$('#loginck').html("잘못 입력하셨습니다.").css("color","tomato");
				}else{
					// alert("로그인 성공");
			
					window.location.href = "<%=ctx%>/main.do#work";
				}
			}
		});
}); --%>

	</script>


	</body>
</html>