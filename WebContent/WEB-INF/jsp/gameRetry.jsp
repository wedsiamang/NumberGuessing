<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List,model.Game"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Number Guessing</title>

<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=1, user-scalable=yes">
<link rel="stylesheet" href="css/gameNum.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<%
String ran2num6 = (String) request.getParameter("ran2num6");
String ran3num3 = (String) request.getParameter("ran3num3");
String ran3num6 = (String) request.getParameter("ran3num6");
String ran3num9 = (String) request.getParameter("ran3num9");
List<Game> gameList = (List<Game>) request.getAttribute("gameList");
%>

<script>
setTimeout(function(){
	window.location.href = '/LogOutServlet';
},300*1000);
</script>
</head>
<body>
	<div class="line-bc">
		
		<div class="mx-auto text-center" style="width: 90%;">
			<h2 class="text-center mb-3">++Number Guessing++</h2>

			<%
			if (ran2num6 != null) {
			%>
			<table>
				<tr>
					<td><img src="pneko.png" width="80" height="120"></td>
					<td><h5>1～6の数を2つ入力してね</h5></td>
				</tr>
			</table>
			<div class="list-group">
				<div class="list-group-item">
					<table class="table table-striped">
						<thead>
							<tr>
								<th scope="col">A</th>
								<th scope="col">B</th>

								<th scope="col">HIT<br>数も場所も正解！
								</th>
								<th scope="col">BLOW<br>その数で正解！<br>でも場所が違うよ
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
			<br>

			<div class="mx-auto text-center">
				<form action="/GameServlet?ran2num6" method="post">
					<div class="row">
						<div class="col">
							<input type="number" name="one" style="width: 60px;" max="6"
								min="1" class="form-control">
						</div>
						<div class="col">
							<input type="number" name="two" style="width: 60px;" max="6"
								min="1" class="form-control">
						</div>
					</div>
					<%
					for (Game g : gameList) {
					%>
					<input type="hidden" name="id" value=<%=g.getId()%>>
					<%
					}
					%>
					<input type="submit" value="judge">
				</form>
			</div>
			<%
			} else if (ran3num3 != null) {
			%>
			<table>
				<tr>
					<td><img src="pneko.png" width="80" height="120"></td>
					<td><h5>1～３の数を３つ入力してね</h5></td>
				</tr>
			</table>
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
								<th scope="col">BLOW<br>その数で正解！<br>でも場所が違うよ
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
			<br>

			<div class="mx-auto text-center">
				<form action="/GameServlet?ran3num3" method="post">
					<div class="row">
						<div class="col">
							<input type="number" name="one" style="width: 60px;" max="3"
								min="1" class="form-control">
						</div>
						<div class="col">
							<input type="number" name="two" style="width: 60px;" max="3"
								min="1" class="form-control">
						</div>
						<div class="col">
							<input type="number" name="three" style="width: 60px;" max="3"
								min="1" class="form-control">
						</div>
					</div>
					<%
					for (Game g : gameList) {
					%>
					<input type="hidden" name="id" value=<%=g.getId()%>>
					<%
					}
					%>
					<input type="submit" value="judge">
				</form>
			</div>
			<%
			} else if (ran3num6 != null) {
			%>
			<table>
				<tr>
					<td><img src="pneko.png" width="80" height="120"></td>
					<td><h5>1～6の数を３つ入力してね</h5></td>
				</tr>
			</table>
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
								<th scope="col">BLOW<br>その数で正解！<br>でも場所が違うよ
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
			<br>

			<div class="mx-auto text-center">
				<form action="/GameServlet?ran3num6" method="post">
					<div class="row">
						<div class="col">
							<input type="number" name="one" style="width: 60px;" max="6"
								min="1" class="form-control">
						</div>
						<div class="col">
							<input type="number" name="two" style="width: 60px;" max="6"
								min="1" class="form-control">
						</div>
						<div class="col">
							<input type="number" name="three" style="width: 60px;" max="6"
								min="1" class="form-control">
						</div>
					</div>
					<%
					for (Game g : gameList) {
					%>
					<input type="hidden" name="id" value=<%=g.getId()%>>
					<%
					}
					%>
					<input type="submit" value="judge">
				</form>
			</div>
			<%
			} else if (ran3num9 != null) {
			%>
			<table>
				<tr>
					<td><img src="pneko.png" width="80" height="120"></td>
					<td><h5>1～9の数を３つ入力してね</h5></td>
				</tr>
			</table>
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
								<th scope="col">BLOW<br>その数で正解！<br>でも場所が違うよ
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
			<br>

			<div class="mx-auto text-center">
				<form action="/GameServlet?ran3num9" method="post">
					<div class="row">
						<div class="col">
							<input type="number" name="one" style="width: 60px;" max="10"
								min="1" class="form-control">
						</div>
						<div class="col">
							<input type="number" name="two" style="width: 60px;" max="10"
								min="1" class="form-control">
						</div>
						<div class="col">
							<input type="number" name="three" style="width: 60px;" max="10"
								min="1" class="form-control">
						</div>
					</div>
					<%
					for (Game g : gameList) {
					%>
					<input type="hidden" name="id" value=<%=g.getId()%>>
					<%
					}
					%>
					<input type="submit" value="judge">
				</form>
			</div>
			<%
			}
			%>

		</div>
	</div>
</body>
</html>