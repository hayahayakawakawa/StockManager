<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="/css/home.css">
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<script src="/js/main.js"></script>
	<script src="/js/modal.js"></script>
</head>
<body>
	<h1>testpage</h1>
	<button id="openModal">+</button>
	<div class="main">
		<div class="main-content">
			<table>
			<tr th:each="item : ${itemList}">
				<td th:text="${item.name}"></td>
				<td th:text="${item.category}"></td>
				<td th:text="${item.pics}"></td>
				<td th:text="${item.registDate}"></td>
				<td th:text="${item.expirationDays}"></td>
                <td><form action="/delete" method="post" id="delete">
                	<input type="hidden" id="id" name="id" th:value="${item.id}" />
                	<input type="image" src="/image/delete.png" />
                </form></td>
            </tr>
            </table>
		</div>
	</div>
	
	<div class="modal" id="addModal" >
		<div class="modal-content">
			<span class="close" id="closeModal">✕</span>
			
			<form action="/addForm" method="post" id="addForm">
				<label for="name">商品名:</label>
				<input type="text" id="name" name="name" /><br/>
				<label for="category">カテゴリ:</label>
				<input type="text" id="category" name="category" /><br/>
				<label for="pics">数量:</label>
				<input type="number" id="pics" name="pics" /><br/>
				<label for="registDate">登録日:</label>
				<input type="date" id="registDate" name="registDate" /><br/>
				<label for="expirationDays">有効期限（日数）:</label>
				<input type="number" id="expirationDays" name="expirationDays" /><br/>
				<input id="addButton" type="submit">Submit</input>
			</form>
		</div>
	</div>
</body>
</html>