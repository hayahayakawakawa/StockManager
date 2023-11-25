// ページ読み込み時の処理
$(document).ready(function() {
	// ボタンクリック時に発火
	$("#openModal").click(function() {
		$("#addModal").show();
	});
	
	// 閉じるボタンクリック時に発火
	$("#closeModal").click(function() {
        $("#addModal").hide(); // モーダルを非表示
    });
})