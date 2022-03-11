
function openInputJsonUploadModal(){
    $('#fieldName').val('inputJson');
    openUploadModal();
}

function openJoltJsonUploadModal(){
    $('#fieldName').val('joltJson');
    openUploadModal();
}

function openUploadModal(){
    //populate hidden fields
    $('#uploadInputJson').val($('#inputJson').val());
    $('#uploadJoltJson').val($('#joltJson').val());
    $('#uploadOutputJson').val($('#outputJson').val());

    $('#fileUploadModal').modal('show');
}

function downloadOutputJson(){
    $('#downloadOutputJson').val($('#outputJson').val());
    $('#downloadForm').submit();
}
