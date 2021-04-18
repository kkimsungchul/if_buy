
function getCoinList() {
    var returnData;
    $.ajax({
        url : "/coin/coinList",
        type : "GET",
        dataType : "json",
        data : {},
        success : function (data){
            console.log(data)
            returnData = data;
        },error : function (data) {
            console.log(data)
        }
    })
    return returnData;
}