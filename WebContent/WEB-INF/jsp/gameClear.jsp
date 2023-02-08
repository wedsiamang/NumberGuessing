<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List,model.Game,model.GameRank"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Number Guessing</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=1, user-scalable=yes">
<link rel="stylesheet" href="css/gameNum.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
<%
String ran2num6 = (String) request.getParameter("ran2num6");
String ran3num3 = (String) request.getParameter("ran3num3");
String ran3num6 = (String) request.getParameter("ran3num6");
String ran3num9 = (String) request.getParameter("ran3num9");
List<Game> gameList = (List<Game>) request.getAttribute("gameList");
List<GameRank> gameRankList = (List<GameRank>) request.getAttribute("gameRankList");
Game ans = (Game) request.getAttribute("ans");
int count = (int) request.getAttribute("count");
int nowPoint = (int) request.getAttribute("nowPoint");
%>
<script>
	setTimeout(function() {
		window.location.href = '/LoginServlet';
	}, 300 * 1000);
</script>
</head>
<body>
	<div class="line-bc">
		<div class="mx-auto text-center" style="width: 90%;">
			<h2 class="text-center mb-3">+++ Number Guessing +++</h2>
			<table>
				<tr>
					<td><img src="pneko.png" width="80" height="120"></td>
					<td><h2>GAME CLEARED！</h2></td>
				</tr>
			</table>
			<h6><%=nowPoint %>ポイントGETしたよ。</h6>
			<%
			if (ran2num6 != null) {
			%>
			<div class="list-group">
				<div class="list-group-item">
					<table class="table table-striped">
						<thead>
							<tr>
								<th scope="col">A</th>
								<th scope="col">B</th>
								<th scope="col">HIT<br>数も場所も正解！
								</th>
								<th scope="col">BLOW<br>その数で正解！でも場所が違うよ
								</th>
							</tr>
						</thead>
						<tbody>
							<%
							for (Game g : gameList) {
							%>
							<tr>
								<td><%=g.getOne()%></td>
								<td><%=g.getTwo()%><!-- getThird() input--></td>
								<td><%=g.getHit()%><!-- getBlow() keisansiki--></td>
								<td><%=g.getBlow()%></td>
							</tr>
							<%
							}
							%>
						</tbody>
					</table>
				</div>
			</div>
			<h4>
				<%=count%>回目で正解。 答えは<%=ans.getNumA()%><%=ans.getNumB()%></h4>
			<form action="?" method="post">
				<input type="hidden" name="name" value="<%=ans.getName()%>">
				<input type="hidden" name="count" value="<%=ans.getCount()%>">
				<button type="submit"
					formaction="/GameClearServlet?again">もう一度やる</button>
				<button type="submit"
					formaction="/GameClearServlet?rank">ランキングを見る</button>
			</form>
			<%
			} else if (ran3num3 != null) {
			%>
			<div class="list-group">
				<div class="list-group-item">
					<table class="table table-striped">
						<thead>
							<tr>
								<th scope="col">A</th>
								<th scope="col">B</th>
								<th scope="col">C</th>
								<th scope="col">HIT<br>場所も数も正解！
								</th>
								<th scope="col">BLOW<br>その数で正解！でも場所が違うよ
								</th>
							</tr>
						</thead>
						<tbody>
							<%
							for (Game g : gameList) {
							%>
							<tr>
								<td><%=g.getOne()%></td>
								<td><%=g.getTwo()%><!-- getThird() input--></td>
								<td><%=g.getThree()%><!-- getHit() keisansiki--></td>
								<td><%=g.getHit()%><!-- getBlow() keisansiki--></td>
								<td><%=g.getBlow()%></td>
							</tr>
							<%
							}
							%>
						</tbody>
					</table>
				</div>
			</div>
			<h4>
				<%=count%>回目で正解。答えは<%=ans.getNumA()%><%=ans.getNumB()%><%=ans.getNumC()%></h4>
			<form action="?" method="post">
				<input type="hidden" name="name" value="<%=ans.getName()%>">
				<input type="hidden" name="count" value="<%=ans.getCount()%>">
				<button type="submit"
					formaction="/GameClearServlet?again">もう一度やる</button>
				<button type="submit"
					formaction="/GameClearServlet?rank">ランキングを見る</button>
			</form>
			<%
			} else if (ran3num6 != null) {
			%>
			<div class="list-group">
				<div class="list-group-item">
					<table class="table table-striped">
						<thead>
							<tr>
								<th scope="col">A</th>
								<th scope="col">B</th>
								<th scope="col">C</th>
								<th scope="col">HIT<br>場所も数も正解！
								</th>
								<th scope="col">BLOW<br>その数で正解！でも場所が違うよ
								</th>
							</tr>
						</thead>
						<tbody>
							<%
							for (Game g : gameList) {
							%>
							<tr>
								<td><%=g.getOne()%></td>
								<td><%=g.getTwo()%><!-- getThird() input--></td>
								<td><%=g.getThree()%><!-- getHit() keisansiki--></td>
								<td><%=g.getHit()%><!-- getBlow() keisansiki--></td>
								<td><%=g.getBlow()%></td>
							</tr>
							<%
							}
							%>
						</tbody>
					</table>
				</div>
			</div>
			<h4>
				<%=count%>回目で正解。答えは<%=ans.getNumA()%><%=ans.getNumB()%><%=ans.getNumC()%></h2>
				<form action="?" method="post">
					<input type="hidden" name="name" value="<%=ans.getName()%>">
					<input type="hidden" name="count" value="<%=ans.getCount()%>">
					<button type="submit"
						formaction="/GameClearServlet?again">もう一度やる</button>
					<button type="submit"
						formaction="/GameClearServlet?rank">ランキングを見る</button>
				</form>
				<%
				} else if (ran3num9 != null) {
				%>
				<div class="list-group">
					<div class="list-group-item">
						<table class="table table-striped">
							<thead>
								<tr>
									<th scope="col">A</th>
									<th scope="col">B</th>
									<th scope="col">C</th>
									<th scope="col">HIT<br>場所も数も正解！
									</th>
									<th scope="col">BLOW<br>その数で正解！でも場所が違うよ
									</th>
								</tr>
							</thead>
							<tbody>
								<%
								for (Game g : gameList) {
								%>
								<tr>
									<td><%=g.getOne()%></td>
									<td><%=g.getTwo()%><!-- getThird() input--></td>
									<td><%=g.getThree()%><!-- getHit() keisansiki--></td>
									<td><%=g.getHit()%><!-- getBlow() keisansiki--></td>
									<td><%=g.getBlow()%></td>
								</tr>
								<%
								}
								%>
							</tbody>
						</table>
					</div>
				</div>
				<h4>
					<%=count%>回目で正解。答えは<%=ans.getNumA()%><%=ans.getNumB()%><%=ans.getNumC()%></h4>
				<form action="?" method="post">
					<input type="hidden" name="name" value="<%=ans.getName()%>">
					<input type="hidden" name="count" value="<%=ans.getCount()%>">
					<button type="submit"
						formaction="/GameClearServlet?again">もう一度やる</button>
					<button type="submit"
						formaction="/GameClearServlet?rank">ランキングを見る</button>
				</form>
				<%
				}
				%>
			
		</div>
	</div>
</body>
</html>