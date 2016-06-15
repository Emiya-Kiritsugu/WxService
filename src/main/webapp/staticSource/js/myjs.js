/**
 * Created by xyd on 16/6/8.
 */
function changeTeacher(id){
    console.log(id)
};
function test(){
    console.log('dfdfdf',$('#textarea2').val());
}
function upload(){
    console.log($('#textarea2').val())
    $.post("/view/addnotice",{data:$('#textarea2').val()},function(result){
        alert("上传成功");
        window.location.href='/view/managenotice';
    });
}