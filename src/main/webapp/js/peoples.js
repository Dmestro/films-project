/**
 * Created by Lytki on 14.04.2017.
 */
$(document).ready(()=>{
    getAll();
    activateDialogButtons();
});
var actionFlag;
var ID;
var FIRST_NAME;
var LAST_NAME;
function getAll(){
    $.get("/peoples",(data)=>{
        var countries = data.peoples;
        var $table = $('.table-peoples>tbody');
        $table.empty();

        countries.forEach((people)=>{
            var tempalte = `<tr>
                <th class="people-id-${people.id}"scope="row">${people.id}</th>
                <td class="people-name-${people.id}">${people.firstName}</td>
                <td class="people-lastname-${people.id}">${people.lastName}</td>
                <td><a class="changer"><i id-attr="${people.id}" class="glyphicon glyphicon-pencil"></i></a>
                    <a class="remover" "><i id-attr="${people.id}" class="glyphicon glyphicon-remove"></i></a></td>
            </tr>`;
            $table.append(tempalte);
        });

        var $countryChangers = $('.changer');

        for(var i=0;i<$countryChangers.length;i++){
            $countryChangers[i].onclick=(event)=>{
                console.log(event.target);
                console.log($(event.target));
                ID=$(event.target).attr('id-attr');
                FIRST_NAME = $('.people-name-'+ID).text();
                LAST_NAME = $('.people-lastname-'+ID).text();
                var $opacifier = $('.opacifier');
                var $addCountryDialog = $('.add-dialog');
                $opacifier.show();
                $addCountryDialog.show();
                $('#fname').val(FIRST_NAME);
                $('#lname').val(LAST_NAME);
                actionFlag="UPDATE";
            };
        }

        var $countryRemovers = $('.remover');
        for(var i=0;i<$countryRemovers.length;i++){
            $countryRemovers[i].onclick=(event)=>{
                console.log(event.target);
                console.log($(event.target));
                ID=$(event.target).attr('id-attr');
                $.post('/peoples',{action:"DELETE",id:ID},function(){getAll();
                });

            };
        }



    })


}
function activateDialogButtons(){
    $('#add-dialog-button').click(()=>{
        var $opacifier = $('.opacifier');
        var $addCountryDialog = $('.add-dialog');
        $('#fname').val("");
        $('#lname').val("");
        $opacifier.show();
        $addCountryDialog.show();
        $('#fname').focus();

        actionFlag="ADD";
    });
    $('#cancel-add-button').click(()=>{
        var $opacifier = $('.opacifier');
        var $addCountryDialog = $('.add-dialog');
        $opacifier.hide();
        $addCountryDialog.hide();
    });

    $('#add-button').click(()=>{
        if(actionFlag==="ADD"){
            var firstName=$('#fname').val();
            var lastName=$('#lname').val();
            console.log(firstName+" "+lastName);
            $.post('/peoples',{action:actionFlag,firstName:firstName,lastName:lastName},function(){getAll();});
            var $opacifier = $('.opacifier');
            var $addCountryDialog = $('.add-dialog');
            $opacifier.hide();
            $addCountryDialog.hide();

        }

        if(actionFlag==="UPDATE"){
            $.post('/peoples',{action:actionFlag,people:{id:ID,peopleName:$('#fname').val(),peopleLastName:$('#lname').val()}},function(){getAll();});
            var $opacifier = $('.opacifier');
            var $addCountryDialog = $('.add-dialog');
            $opacifier.hide();
            $addCountryDialog.hide();

        }
    });



}