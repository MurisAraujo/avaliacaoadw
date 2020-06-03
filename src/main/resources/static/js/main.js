
$(document).ready(function(){
    $('.table .eBtn').on('click', function(){
        
        var id = $(this).data("id");
        
        $.getJSON("/editUser/" + id, function(data){
            console.log(data);
            var form = $(".myForm");
            $(".modal-body").append("<input type=\"hidden\" class=\"form-control\" name=\"id\" value=\"\"/>");
            form.find("input[name=id]").val(data.id);
            form.find("input[name=userName]").val(data.userName);
            form.find("input[name=senha]").val(data.senha);
            $(".custom-control-input[value= "+ data.status+ "]").prop("checked", true);
            form.find("input[name=nome]").val(data.nome);
        });
        
        $('.myForm #exampleModal').modal();
    });
    
    $('.table .dBtn').on('click', function(){
        
        var id = $(this).data("id");
        console.log(id);
        if($('#deleteUser').on('click', function(){
            $.post("/deleteUser/" + id, null, function(result){
                console.log(result);
                window.location.href = "/";
            });
        }));
    });
            
});
