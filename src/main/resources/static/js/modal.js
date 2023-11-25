// ページ読み込み時の処理
$(document).ready(function() {
	validationCheck();
	// ボタンクリック時に発火
	$("#openModal").click(function() {
		$("#overlay").show();
		$("#addModal").show();
		$("#openModal").hide();
	});
	
	// 閉じるボタンクリック時に発火
	$("#closeModal").click(function() {
        $("#addModal").hide(); // モーダルを非表示
        $("#overlay").hide();
        $("#openModal").show();
    });
});

$(function() {
	$('.addForm').on('change', function() {
		validationCheck();
	});
});

function validationCheck() {
	var name = document.getElementById('name').value;
	var category = document.getElementById('category').value;
	var pics = document.getElementById('pics').value;
	var registDate = document.getElementById('registDate').value;
	var expirationDays = document.getElementById('expirationDays').value;
	
	if (name === '' || category === '' || pics === '' || registDate === '' || expirationDays === '') {
		$("#addButton").addClass('null-form');
		document.getElementById('addButton').disabled = true;
	} else {
		$("#addButton").removeClass('null-form');
		document.getElementById('addButton').disabled = false;
	}
}