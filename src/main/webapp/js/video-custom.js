$('#link').click(function () {
    var src = 'https://www.youtube.com/embed/YE7VzlLtp-4';
    $('#staticBackdrop').modal('show');
    $('<iframe>').attr({
        'src': src,
        'width': '560',
        'height': '315',
        'allow': 'encrypted-media'
    }).css('border', '0').appendTo('#staticBackdrop .video-container');
});

$('#staticBackdrop button').click(function () {
    $('#staticBackdrop iframe').removeAttr('src');
});