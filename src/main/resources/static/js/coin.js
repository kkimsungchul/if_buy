
function getCoinList() {
    var returnData;
    $.ajax({
        url : "/coin/coin",
        type : "GET",
        async: false,
        data : {},
        success : function (data){
            console.log(data)
            returnData = data;
            return returnData;
        },error : function (e) {
            console.log(e)
        }
    });
}

function getCoinDetail(coinName){

    $.ajax({
        url: "/coin/coin/"+coinName,
        type : "GET",
        data : {},
        success : function (data){
            console.log(data);

        },error : function (e){
            console.log(e);

        }

    })





}