<%@page import="domin.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>OutEnglish</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="./assets/css/home.css">
</head>
<body>
        <div class="wrap">
            <header>
                <img src="./assets/logo/weg.png" alt="weg">
                <%
					User user = (User)session.getAttribute("user");
					
					if ( user == null ) {

				%>
                	<p id="user"><a href="login.jsp">로그인</a> 및 <a href="signup.jsp">회원가입</a></p>
				<%
					}else {
				%>
					<div id="user">
						<p>환영합니다 <%= user.getName() %>님</p>
						<p style="text-align: right;"><a href="logout.jsp">로그아웃</a></p>
					</div>
				<%
					}
				%>
                <ul id="center-nav">
                    <li><a href="#">홈</a></li>
                    <li><a href="#">강의</a></li>
                    <li><a href="vocaList.jsp">단어장</a></li>
                    <li><a href="#">커뮤니티</a></li>
                </ul>
            </header>
            <section id="visual">
                <div class="content">
                    <h1 id="title">Our English</h1>
                    <p id="sub-title">Your life is getting better</p>
                </div>
            </section>
            <section id="section_1">
                <h1>우리의 자랑</h1>
                <div class="content">
                    <div class="boxA">
                        <img src="./assets/image/sec1.jpg" alt="sec1">
                        <img src="./assets/image/sec2.jpg" alt="sec2">
                        <img src="./assets/image/sec3.jpg" alt="sec3">
                    </div>
                    <div class="boxB">
                        <img src="./assets/image/sec4.jpg" alt="sec4">
                        <img src="./assets/image/sec5.jpg" alt="sec5">
                    </div>
                </div>
                <a href="#"><button>학습하기</button></a>
            </section>
            <section id="section_2">
                <div class="content">
                    <div class="boxA">
                        <img src="./assets/icon/browser.png" alt="browser">
                    </div>
                    <div class="boxB">
                        <h1>당신의 단어장을 공유하세요</h1>
                        <a href="vocaList.jsp"><button>공유하기</button></a>
                    </div>
                </div>
            </section>
            <section id="section_3">
                <div class="content">
                    <div class="box1">
                        <div class="left">
                            <img src="./assets/icon/chat.png" alt="chat" style="width: 100px;">
                        </div>
                        <div class="right">
                            <h1 class="box_right">"도움이  필요하세요?"</h1>
                            <a href="#"><button class="btn_right">요청하기</button></a>
                        </div>
                    </div>
                    <div class="box2">
                        <div class="left">
                            <img src="./assets/icon/newspaper.png" alt="newpaper" style="width: 100px;">
                        </div>
                        <div class="right">
                            <h1 class="box_right">"피드백이 필요해요!"</h1>
                            <a href="#"><button class="btn_right">피드백하기</button></a>
                        </div>
                    </div>
                </div>
            </section>
            <footer>
                <div class="f_cont">
                    <img src="./assets/logo/weg_white.png" alt="white" style="width: 90px;">
                    <ul class="center-var">
                        <li><a href="#">PRODUCT</a></li>
                        <li><a href="#">ABOUT US</a></li>
                        <li><a href="#">LEARN MORE</a></li>
                    </ul>
                    <ul class="right-var">
                        <li>
                            <a href="https://www.facebook.com/"><img src="./assets/icon/facebook.png" alt="facebook"></a>
                        </li>
                        <li>
                            <a href="https://www.instagram.com/"><img src="./assets/icon/instar.png" alt="instar"></a>
                        </li>
                        <li>
                            <a href="https://www.instagram.com/"><img src="./assets/icon/pinterest.png" alt="pinterest"></a>
                        </li>
                        <li>
                            <a href="https://twitter.com/?lang=ko"><img src="./assets/icon/twitter.png" alt="twitter"></a>
                        </li>
                    </ul>
                </div>
            </footer>
        </div>
    </body>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</html>