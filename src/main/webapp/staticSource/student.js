/**
 * Created by xyd on 16/4/11.
 */
function update(studentNo){
    var tds = $("#"+studentNo).children("td");
    $("#studentNo").attr("value",$(tds).filter(function(index){return index ==0}).html());
    $("#studentNo").attr("readonly",true);
    $("#studentName").val($(tds).filter(function(index){return index ==1}).html());
    $("#studentName").attr("readonly",true);
    $("#grade").val($(tds).filter(function(index){return index ==2}).html())
    $("#grade").attr("readonly",true);
    $("#school").val($(tds).filter(function(index){return index ==3}).html());
    $("#school").attr("readonly",true)
    $("#sexbox").attr("hidden",true);;
    $("#achieve").val($(tds).filter(function(index){return index ==4}).html());
}

function add(){
    $("#studentNo").val("");
    $("#studentNo").attr("readonly",true);
    $("#studentName").val("");
    $("#studentName").removeAttr("readonly");
    $("#grade").val("")
    $("#grade").removeAttr("readonly")
    $("#sexbox").removeAttr("hidden")
    $("#school").val("");
    $("#school").removeAttr("readonly")
    $("#achieve").val("");
}

function deleteStu(studentNo){
    if(confirm("确定要删除"))
    window.location.href = "/view/deletestudent?studentNo="+studentNo;
}