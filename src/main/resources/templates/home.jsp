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
	<h1>StockManager</h1>
	<button id="add-button">+</button>
	<div id="overlay"></div>
	<div class="main">
		<div class="main-content">
			<div class="item-list" th:each="item : ${itemList}" th:id="${item.id}">
				<div class="item-name">
					<p th:text="${item.name}"></p>
				</div>
				<div class="item-category">
					<p class="item-list-title">カテゴリー</p>
					<p class="item-list-colon">：</p>
					<p class="item-list-info" th:text="${item.category}"></p>
				</div>
				<div class="item-pics">
					<p class="item-list-title">数量</p>
					<p class="item-list-colon">：</p>
					<p class="item-list-info" th:text="${item.pics}"></p>
				</div>
				<div class="item-registDate">
					<p class="item-list-title">登録日</p>
					<p class="item-list-colon">：</p>
					<p class="item-list-info" th:text="${item.registDate}"></p>
				</div>
				<div class="item-expirationDays">
					<p class="item-list-title">消費日数</p>
					<p class="item-list-colon">：</p>
					<p class="item-list-info" th:text="${item.expirationDays * item.pics}"></p>
                </div>
                <div class="item-edit">
                	<img src="/image/edit.png" class="edit-button" th:id="${item.id}" onclick="setEditValue(this);" />
                </div>
                <div class="item-delete">
                	<form action="/delete" method="post" id="delete">
                		<input type="hidden" id="id" name="id" th:value="${item.id}" />
                		<input type="image" src="/image/delete.png" onclick="confirmDelete(event)"/>
                	</form>
                </div>
            </div>
		</div>
	</div>
	
	<div class="modal" id="editModal" >
		<div class="modal-content">
			<span class="close-button" id="edit-close">✕</span>
			<p class="modal-title">アイテムの編集</p>
			<form action="/editForm" method="post" id="editForm">
				<div class="modal-form">
					<div class="form-name-area">
						<label for="name">商品名：</label>
						<input type="text" id="edit-name" name="name" />
					</div>
					<div class="form-category-area">
						<label for="category">カテゴリー：</label>
						<input type="text" id="edit-category" name="category" />
					</div>
					<div class="form-pics-area">
						<label for="pics">数量：</label>
						<input type="number" id="edit-pics" name="pics" />
					</div>
					<div class="form-registDate-area">
						<label for="registDate">登録日：</label>
						<input type="date" id="edit-registDate" name="registDate" />
					</div>
					<div class="form-expirationDays-area">
						<label for="expirationDays">消費日数：</label>
						<input type="number" id="edit-expirationDays" name="expirationDays" />
					</div>
					<div class="form-submit-area">
						<input type="hidden" id="edit-id" name="id" />
						<input id="edit-submit" type="submit" value="保存" class="submit-button"></input>
					</div>
				</div>
			</form>
		</div>
	</div>
	
	<div class="modal" id="addModal" >
		<div class="modal-content">
			<span class="close-button" id="add-close">✕</span>
			<p class="modal-title">アイテムの追加</p>
			<form action="/addForm" method="post" id="addForm">
				<div class="modal-form">
					<div class="form-name-area">
						<label for="name">商品名：</label>
						<input type="text" id="add-name" name="name" />
					</div>
					<div class="form-category-area">
						<label for="category">カテゴリー：</label>
						<input type="text" id="add-category" name="category" />
					</div>
					<div class="form-pics-area">
						<label for="pics">数量：</label>
						<input type="number" id="add-pics" name="pics" />
					</div>
					<div class="form-registDate-area">
						<label for="registDate">登録日：</label>
						<input type="date" id="add-registDate" name="registDate" />
					</div>
					<div class="form-expirationDays-area">
						<label for="expirationDays">消費日数：</label>
						<input type="number" id="add-expirationDays" name="expirationDays" />
					</div>
					<div class="form-submit-area">
						<input id="add-submit" type="submit" value="登録" class="submit-button"></input>
					</div>
				</div>
			</form>
		</div>
	</div>
	
</body>
</html>