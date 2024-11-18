// Edit 버튼 클릭 시 AJAX 요청 (수정)
$(".edit-btn").click(function() {
    var bookId = $(this).data("id"); // data-id 속성에서 book ID 가져오기

    window.location.href="/book/edit/" + bookId;
});

// Delete 버튼 클릭 시 AJAX 요청 (삭제)
$(".delete-btn").click(function() {
    var bookId = $(this).data("id"); // data-id 속성에서 book ID 가져오기

    // 사용자에게 삭제 여부 확인
    if (confirm("정말 삭제하시겠습니까?")) {
        $.ajax({
            type: "DELETE",
            url: "/book/delete/" + bookId, // URL에 ID 포함
            success: function(response) {
                // 성공적으로 삭제되면, 해당 행 제거
                alert("Book deleted successfully.");
                window.location.href="/book/list"
            },
            error: function(xhr, status, error) {
                alert("Error: " + error);
            }
        });
    }
});