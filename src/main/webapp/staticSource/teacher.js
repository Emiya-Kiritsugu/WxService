/**
 * Created by xyd on 16/4/11.
 */
function update(teacherNo){
    var tds = $("#"+teacherNo).children("td");
    $("#teacherNo").attr("value",$(tds).filter(function(index){return index ==0}).html());
    $("#teacherNo").attr("readonly",true);
    $("#teacherName").val($(tds).filter(function(index){return index ==1}).html());
    $("#teacherName").attr("disabled",true);
    $("#profile").val($(tds).filter(function(index){return index ==2}).html());
    $("#achieve").val($(tds).filter(function(index){return index ==3}).html());
}

function add(){
    $("#teacherNo").val("");
    $("#teacherNo").attr("readonly",true);
    $("#teacherName").val("");
    $("#teacherName").removeAttr("disabled");
    $("#profile").val("");
    $("#achieve").val("");
}

function deleteTea(teacherNo){
    if(confirm("确定要删除"))
        window.location.href = "/view/deleteteacher?teacherNo="+teacherNo;
}