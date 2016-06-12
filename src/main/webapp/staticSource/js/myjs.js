/**
 * Created by xyd on 16/6/8.
 */
function changeTeacher(id){
    console.log(id)
};
function test(){
    alert("ddf")
    console.log('dfdfdf',$('#textarea2').val());
}
function upload(){
    $.post("/view/notice",{data:$('#textarea2').val()},function(result){
        alert("上传成功")
        window.location.href='/pages/template/notice.jsp';
    });
}