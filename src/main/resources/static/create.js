$(document).ready(function () {
    $('#submitButton').on('click', function (event) {
        event.preventDefault();

        // Collect form data
        const formData = {
            title: $('#title').val(),
            author: $('#author').val(),
            description: $('#description').val()
        };

        // Send data using AJAX
        $.ajax({
            type: 'POST', // HTTP method
            url: '/api/book/create', // Server endpoint
            contentType: 'application/json', // Specify JSON format
            data: JSON.stringify(formData),
            success: function (res) {
                alert(res.title + " 등록 성공")
                window.location.href="/book/list"
            },
            error: function (error) {
                console.error('Error:', error);
            }
        });
    });
});