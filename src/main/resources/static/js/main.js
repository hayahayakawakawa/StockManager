/*
$(document).ready(function() {
	$("#addForm").submit(function(event) {
		// フォームのデフォルトの送信を防ぐ
		event.preventDefault();

		// フォームデータを取得
		var formData = $(this).serialize();
            
		// 非同期でサーバーにデータを送信
		$.ajax({
			type: "POST",
			url: "/api/item/addForm",
			data: formData,
			success: function(response) {
				// サーバーの処理が成功した場合の処理
				console.log("Success:", response);
			},
			error: function(error) {
				// サーバーの処理がエラーの場合の処理
				console.error("Error:", error);
			}
		});
	});
});
*/