<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head>
	<meta charset="UTF-8">
	<title>StockManager</title>
	<link rel="stylesheet" href="/css/home.css">
	<link rel="stylesheet" href="/css/modal.css">
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
			<div class="item-list" th:each="item : ${itemList}">
				<div class="item-name">
					<p th:text="${item.name}"></p>
				</div>
				<div class="item-category">
					<p class="item-list-title">カテゴリー</p>
					<p class="item-list-info" th:text="： + ${item.category}"></p>
				</div>
				<div class="item-pics">
					<p class="item-list-title">数量</p>
					<p class="item-list-info" th:text="： + ${item.pics}"></p>
				</div>
				<div class="item-registDate">
					<p class="item-list-title">登録日</p>
					<p class="item-list-info" th:text="： + ${item.registDate}"></p>
				</div>
				<div class="item-expirationDays">
					<p class="item-list-title">消費日数</p>
					<p class="item-list-info" th:text="： + ${item.expirationDays * item.pics}"></p>
                </div>
                <div class="item-delete">
                	<form action="/delete" method="post" id="delete">
                		<input type="hidden" id="id" name="id" th:value="${item.id}" />
                		<input type="image" src="/image/delete.png" />
                	</form>
                </div>
            </div>
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