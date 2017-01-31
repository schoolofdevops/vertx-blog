$(document).ready(function() {
	$('#go').click(function() {
		$.ajax({
			url : 'http://localhost:8080/api/dictionary/' + $('#word').val(),
			type : 'get',
			accept : 'application/json',
			success : function(response) {
				$("#meaning").html(response.meaning);
				$("#synonyms").html(response.synonyms);
			}
		});
	});
});