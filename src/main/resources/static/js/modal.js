// ページ読み込み時の処理
$(document).ready(function() {
	editNullCheck();
	addNullCheck();
	getDate();
	// addボタンクリック時に発火
	$("#add-button").click(function() {
		$("#overlay").show();
		$("#addModal").show();
		$("#add-button").hide();
	});
	
	// 閉じるボタンクリック時に発火
	$("#add-close").click(function() {
        $("#addModal").hide();
        $("#overlay").hide();
        $("#add-button").show();
    });
    
    // editボタンクリック時に発火
	$(".edit-button").click(function() {
		editNullCheck();
		$("#overlay").show();
		$("#editModal").show();
		$("#add-button").hide();
	});
	
	// 閉じるボタンクリック時に発火
	$("#edit-close").click(function() {
        $("#editModal").hide();
        $("#overlay").hide();
        $("#add-button").show();
    });
});

// モーダル入力時に発火
$(function() {
	$('.modal-form').on('change', function() {
		editNullCheck();
		addNullCheck();
	});
});

// 未入力チェック（edit）
function editNullCheck() {
	var name = document.getElementById('edit-name').value;
	var category = document.getElementById('edit-category').value;
	var pics = document.getElementById('edit-pics').value;
	var registDate = document.getElementById('edit-registDate').value;
	var expirationDays = document.getElementById('edit-expirationDays').value;
	
	if (name === '' || category === '' || pics === '' || registDate === '' || expirationDays === '') {
		$("#edit-submit").addClass('null-form');
		document.getElementById('edit-submit').disabled = true;
	} else {
		$("#edit-submit").removeClass('null-form');
		document.getElementById('edit-submit').disabled = false;
	}
	console.log("a");
}

// 未入力チェック（add）
function addNullCheck() {
	var name = document.getElementById('add-name').value;
	var category = document.getElementById('add-category').value;
	var pics = document.getElementById('add-pics').value;
	var registDate = document.getElementById('add-registDate').value;
	var expirationDays = document.getElementById('add-expirationDays').value;
	
	if (name === '' || category === '' || pics === '' || registDate === '' || expirationDays === '') {
		$("#add-submit").addClass('null-form');
		document.getElementById('add-submit').disabled = true;
	} else {
		$("#add-submit").removeClass('null-form');
		document.getElementById('add-submit').disabled = false;
	}
}

//editモーダルへのデフォルト値挿入処理
function setEditValue(element) {
	// ID取得
	var id = element.id;
	// item-listの要素を変数化
	var item = document.getElementById(id);
	// それぞれのElementを取得
	var nameEle = $(item).find('.item-name p');
	var cateEle = $(item).find('.item-category .item-list-info');
	var picsEle = $(item).find('.item-pics .item-list-info');
	var registEle = $(item).find('.item-registDate .item-list-info');
	var expirationEle = $(item).find('.item-expirationDays .item-list-info');
	
	// pタグの中身を定義
	var name = nameEle.text();
	var cate = cateEle.text();
	var pics = picsEle.text();
	var regist = registEle.text();
	var expiration = expirationEle.text();
	var expirationDays = expiration / pics;
	
	// editモーダルのinputタグを取得
	var editName = document.getElementById('edit-name');
	var editCate = document.getElementById('edit-category');
	var editPics = document.getElementById('edit-pics');
	var editRegist = document.getElementById('edit-registDate');
	var editExpiration = document.getElementById('edit-expirationDays');
	var editId = document.getElementById('edit-id');
	
	// valueを設定
	editName.value = name;
	editCate.value = cate;
	editPics.value = pics;
	editRegist.value = regist;
	editExpiration.value = expirationDays;
	editId.value = id;
}

// 削除ボタン押下時のアラート
function confirmDelete(event) {
	var confirmMsg = confirm("選択したアイテムを削除します");
	if (confirmMsg) {
		document.getElementById('delete').submit();
	} else {
		event.preventDefault();
	}
}

// 今日の日付取得
function getDate() {
	var today = new Date();
	var yyyy = today.getFullYear();
	var mm = String(today.getMonth() + 1).padStart(2, '0');
	var dd = String(today.getDate()).padStart(2, '0');addNullCheck
	
	var resultDate = yyyy + '-' + mm + '-' + dd;
	document.getElementById('add-registDate').value = resultDate;
	document.getElementById('edit-registDate').value = resultDate;
}