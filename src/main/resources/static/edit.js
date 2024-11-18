$(document).ready(function () {
    $('#submitButton').on('click', function (event) {
        event.preventDefault();

        // Collect form data
        const formData = {
            title: $('#title').val(),
            author: $('#author').val(),
            description: $('#description').val(),
            id : $('#id').val(),
        };

        // Send data using AJAX
        $.ajax({
            type: 'PUT',
            url: '/api/book/edit',
            contentType: 'application/json', 
            data: JSON.stringify(formData),
            success: function (res) {
                alert(res.title + " 수정 성공")
                window.location.href="/book/list"
            },
            error: function (error) {
                console.error('Error:', error);
            }
        });
    });
});